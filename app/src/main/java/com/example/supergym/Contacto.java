package com.example.supergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class Contacto extends AppCompatActivity {

    Button botonpedir;
    RequestQueue requestQueue;
    JSONArray jsonArray;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        botonpedir = findViewById(R.id.buttonpedirrutina);
        user = (Usuario) getIntent().getSerializableExtra("user");

        botonpedir.setOnClickListener(view ->{
                control();
        });
    }

    private void control() {
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://lsptrainer.000webhostapp.com/controlrutina.php?email="+user.getEmail();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    jsonArray = new JSONArray(response);
                    String bandera=jsonArray.getString(0);
                    if(bandera.equalsIgnoreCase("1")) {
                        Toast.makeText(getApplicationContext(),"YA TIENES UNA RUTINA ASIGNADA, AHORA A ENTRENAR!", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"TU ENTRENADOR HA SIDO NOTIFICADO, PODRAS VISUALIZAR TU RUTINA CUANDO ESTE LISTA", Toast.LENGTH_LONG).show();
                        enviardatosdelusuario();
                    }
                    botonpedir.setEnabled(false);
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

    private void enviardatosdelusuario() {

    }

}