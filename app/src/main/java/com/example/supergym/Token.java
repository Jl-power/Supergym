package com.example.supergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Token extends AppCompatActivity {

    EditText texttoken;
    Button bvalidar,bcancelar;
    String token,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_token);

        texttoken = findViewById(R.id.editTexttoken);
        bvalidar = findViewById(R.id.buttonvalidar);
        bcancelar = findViewById(R.id.buttoncancelar);
        token = getIntent().getStringExtra("token");
        email = getIntent().getStringExtra("email");

        bcancelar.setOnClickListener(view ->{
            Intent i = new Intent( Token.this, MainActivity.class);
            startActivity(i);
        });

        bvalidar.setOnClickListener(view ->{
            if (token.equals(texttoken.getText().toString())) {
                Intent i = new Intent(Token.this, Passwordedit.class);
                i.putExtra("email",email);
                startActivity(i);
            }else{
                Toast.makeText(getApplicationContext(),"El token ingresado no es valido",Toast.LENGTH_SHORT).show();
            }
        });
    }
}