package com.example.supergym;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    TextView email;
    EditText pass,tel;
    Usuario user;
    ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

       /* email = findViewById(R.id.textView10);
        pass = findViewById(R.id.textView11);
        tel = findViewById(R.id.textView12);
        foto = findViewById(R.id.imageView5);

        user = (Usuario) getIntent().getSerializableExtra("user");

        email.setText(user.getEmail());
        pass.setText(user.getPassword());
        tel.setText(user.getTelefono());*/

    }
}