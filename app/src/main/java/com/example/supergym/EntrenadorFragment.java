package com.example.supergym;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class EntrenadorFragment extends Fragment {

    private RecyclerView listaEntrenadores;
    private ArrayList<Entrenador> entrenadores;

    public EntrenadorFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private void iniciarEntrenadores() {
        entrenadores = new ArrayList<>();
        entrenadores.add(new Entrenador("Marcos","Santillan","marcos_trainer","381475948","conectado",R.drawable.ejemplo,30,5));
        entrenadores.add(new Entrenador("Ana","Guzman","ifbb_anaguz","3815963123","conectado",R.drawable.ejemplo2,27,3));
        entrenadores.add(new Entrenador("Pablo","Cortez","pablofit_gym","3813914257","desconectado",R.drawable.ejemplo3,29,7));
        entrenadores.add(new Entrenador("Rocio","Alderete","ro_fit_alde","3816198857","conectado",R.drawable.ejemplo4,26,4));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_entrenador, container, false);
        listaEntrenadores = view.findViewById(R.id.rventrenadores);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        listaEntrenadores.setLayoutManager(llm);

        iniciarEntrenadores();
        iniciarAdapter();


        return view;
    }

    public void iniciarAdapter(){
        EntrenadorAdapter ia = new EntrenadorAdapter(entrenadores);
        listaEntrenadores.setAdapter(ia);
    }
}