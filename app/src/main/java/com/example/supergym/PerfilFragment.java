package com.example.supergym;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.Objects;


public class PerfilFragment extends Fragment {

    private TextView tvNombre,tvApellido,tvTelefono,tvAltura,tvObjetivo,tvPeso;
    JSONArray jsonArray;
    RequestQueue requestQueue;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        ImageView imgLogout = view.findViewById(R.id.imgViewLogout);
        Button btnGuardar = view.findViewById(R.id.buttonguardar);
         tvNombre = view.findViewById(R.id.editTextnombre);
         tvApellido = view.findViewById(R.id.editTextapellido);
         tvTelefono = view.findViewById(R.id.editTexttelefono);
         tvObjetivo = view.findViewById(R.id.editTextobjetivo);
         tvAltura = view.findViewById(R.id.editTextaltura);
         tvPeso = view.findViewById(R.id.editTextpeso);

        SharedPreferences preferences =
                getActivity().getSharedPreferences("usuario", Context.MODE_PRIVATE);

        cargarDatos(preferences);

        imgLogout.setOnClickListener(view1 -> {
            Intent i = new Intent(getContext(),MainActivity.class);
            startActivity(i);
        });

        btnGuardar.setOnClickListener(view1 -> {
            guardarDB(preferences);
        });

        return view;
    }

    private void cargarDatos(SharedPreferences preferences) {
        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));

        String url = "https://lsptrainer.000webhostapp.com/consultar_usuario.php?email=" +
                preferences.getString("email","");



        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            jsonArray = new JSONArray(response);
                            if(!Objects.equals(jsonArray.getString(2), "null"))
                            tvNombre.setText(jsonArray.getString(2));
                            if(!Objects.equals(jsonArray.getString(3), "null"))
                            tvApellido.setText(jsonArray.getString(3));
                            if(!Objects.equals(jsonArray.getString(4), "null"))
                            tvObjetivo.setText(jsonArray.getString(4));
                            if(!Objects.equals(jsonArray.getString(5), "null"))
                            tvAltura.setText(jsonArray.getString(5));
                            if(!Objects.equals(jsonArray.getString(6), "null"))
                            tvPeso.setText(jsonArray.getString(6));
                            if(!Objects.equals(jsonArray.getString(8), "null"))
                            tvTelefono.setText(jsonArray.getString(8));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

    private void guardarDB(SharedPreferences preferences) {
        requestQueue = Volley.newRequestQueue(Objects.requireNonNull(getContext()));

            String url = "https://lsptrainer.000webhostapp.com/actualizar_usuario.php?" +
                    "email=" + preferences.getString("email","") +
                    "&nombre=" + tvNombre.getText().toString() +
                    "&apellido=" + tvApellido.getText().toString() +
                    "&telefono=" + tvTelefono.getText().toString() +
                    "&objetivo=" + tvObjetivo.getText().toString() +
                    "&altura=" + tvAltura.getText().toString() +
                    "&peso=" + tvPeso.getText().toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.trim().equalsIgnoreCase("actualizado")){
                        Toast.makeText(getContext(),"Datos guardados!",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(getContext(),"Error al guardar, intente de nuevo",Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getContext(), "Error de Conexion", Toast.LENGTH_SHORT).show();
                }
            });
            requestQueue.add(stringRequest);
        }
}