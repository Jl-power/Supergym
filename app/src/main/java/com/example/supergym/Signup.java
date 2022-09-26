package com.example.supergym;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    Button buttons;
    TextView buttong;
    EditText textemail, textpass, textpass2, texttelefono;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        buttons = findViewById(R.id.buttonregistro);
        buttong = findViewById(R.id.buttoncancelar2);
        textemail = findViewById(R.id.editTextemail);
        textpass = findViewById(R.id.password);
        textpass2 = findViewById(R.id.password2);
        texttelefono = findViewById(R.id.telefono);

        buttong.setOnClickListener(view -> {
            Intent i = new Intent(Signup.this, MainActivity.class);
            startActivity(i);
        });

        buttons.setOnClickListener(view -> {
            if (textemail.getText().toString().isEmpty() || texttelefono.getText().toString().isEmpty() ||textpass.getText().toString().isEmpty() || textpass2.getText().toString().isEmpty() ) {
                Toast.makeText(getApplicationContext(), "ERROR algun campo vacio", Toast.LENGTH_SHORT).show();
            } else {
                if (textpass.getText().toString().equals(textpass2.getText().toString())) {
                    registrar();
                } else {
                    Toast.makeText(getApplicationContext(), "Los Passwords no coinciden", Toast.LENGTH_SHORT).show();
                }
            }
        });}

        private void registrar(){
            requestQueue = Volley.newRequestQueue(this);
            String url = "https://lsptrainer.000webhostapp.com/registro.php?email="+textemail.getText().toString()+"&password="+textpass.getText().toString()+"&telefono="+texttelefono.getText().toString();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    if (response.trim().equalsIgnoreCase("registrado")) {
                        Toast.makeText(getApplicationContext(), "Registro Exitoso!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error al registrarse", Toast.LENGTH_SHORT).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), "Error de Conexion", Toast.LENGTH_SHORT).show();

                }
            });
            requestQueue.add(stringRequest);
        }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_cliente:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_entrenador:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
