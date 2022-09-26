package com.example.supergym;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {
Button rutinas,perfil,contacto,ejercicios;
Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        rutinas = findViewById(R.id.botonrutinas);
        perfil = findViewById(R.id.botonperfil);
        ejercicios = findViewById(R.id.botonejercicios);
        contacto = findViewById(R.id.botoncontacto);
        user = (Usuario) getIntent().getSerializableExtra("user");

        contacto.setOnClickListener(view ->{
            Intent i = new Intent( Menu.this, Contacto.class);
            i.putExtra("user", user);
            startActivity(i);
        });

        perfil.setOnClickListener(view ->{
            Intent i = new Intent( Menu.this, Perfil.class);
            i.putExtra("user", user);
            startActivity(i);
        });
    }
}