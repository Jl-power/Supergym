package com.example.supergym;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;


public class MainActivity extends AppCompatActivity{

    Button login;
    TextView help,signup;
    EditText textemail,textpass;
    RequestQueue requestQueue;
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.button);
        signup = findViewById(R.id.buttonsignup);
        help = findViewById(R.id.textView2);
        textemail = findViewById(R.id.editTextemail);
        textpass = findViewById(R.id.editTextpass);


        login.setOnClickListener(view -> {
                iniciarSesion();
        });

        signup.setOnClickListener(view ->{
            Intent i = new Intent( MainActivity.this, Signup.class);
            startActivity(i);
        });

        help.setOnClickListener(view ->{
            Intent i = new Intent( MainActivity.this, Help.class);
            startActivity(i);
        });
    }

    private void iniciarSesion() {
        requestQueue = Volley.newRequestQueue(this);
        String url = "https://lsptrainer.000webhostapp.com/login.php?email="+textemail.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    jsonArray = new JSONArray(response);
                    String pass=jsonArray.getString(0);
                    String tel =jsonArray.getString(1);
                    if (pass.equals(textpass.getText().toString())){
                        Intent i = new Intent( MainActivity.this, Menu.class);
                        Usuario user = new Usuario(textemail.getText().toString(),pass, tel);
                        i.putExtra("user",user);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),"Verifique su contraseña",Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"El usuario no existe",Toast.LENGTH_SHORT).show();

                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);
    }

}