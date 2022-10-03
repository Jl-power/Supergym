package com.example.supergym;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Menu extends AppCompatActivity {

    InicioFragment inicioFragment = new InicioFragment();
    ProgramaFragment programaFragment = new ProgramaFragment();
    EntrenadorFragment entrenadorFragment = new EntrenadorFragment();
    EjercicioFragment ejercicioFragment = new EjercicioFragment();
    PerfilFragment perfilFragment = new PerfilFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView navigationView = findViewById(R.id.bottomnavigationbar);
        navigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        loadFragment(inicioFragment);
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()){
                case R.id.inicioFragment:
                    loadFragment(inicioFragment);
                    return true;
                case R.id.programaFragment:
                    loadFragment(programaFragment);
                    return true;
                case R.id.entrenadorFragment:
                    loadFragment(entrenadorFragment);
                    return true;
                case R.id.ejercicioFragment:
                    loadFragment(ejercicioFragment);
                    return true;
                case R.id.perfilFragment:
                    loadFragment(perfilFragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }


}