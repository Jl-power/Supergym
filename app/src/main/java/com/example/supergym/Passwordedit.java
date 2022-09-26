package com.example.supergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Passwordedit extends AppCompatActivity {

    EditText textpass,texpass2;
    Button baceptar;
    RequestQueue requestQueue;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordedit);

        textpass = findViewById(R.id.editTextpass);
        texpass2 = findViewById(R.id.editTextrpass);
        baceptar = findViewById(R.id.buttonaceptar);
        email = getIntent().getStringExtra("email");

        baceptar.setOnClickListener(view -> {
            if(textpass.getText().toString().isEmpty() || texpass2.getText().toString().isEmpty()){
                Toast.makeText(getApplicationContext(), "No puede dejar campos vacios", Toast.LENGTH_SHORT).show();
            }else{
            if( textpass.getText().toString().equals(texpass2.getText().toString())) {
                cambiarpassword(email);
                Intent i = new Intent(Passwordedit.this, MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(getApplicationContext(), "Los Passwords no coinciden", Toast.LENGTH_SHORT).show();
            }}
        });
    }

    private void cambiarpassword(String email) {
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://lsptrainer.000webhostapp.com/cambiarpassword.php?email="+email+"&password="+textpass.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equalsIgnoreCase("registrado")) {
                    Toast.makeText(getApplicationContext(), "Nuevo Password aceptado!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Error al cambiar el Password", Toast.LENGTH_SHORT).show();
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
}
