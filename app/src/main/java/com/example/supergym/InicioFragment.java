package com.example.supergym;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class InicioFragment extends Fragment {

    private RecyclerView listaMiniEntrenadores;
    private ArrayList<Entrenador> entrenadores;



    public InicioFragment() {
        // Required empty public constructor
    }

    private void iniciarEntrenadores() {
        entrenadores = new ArrayList<>();
        entrenadores.add(new Entrenador("Marcos","Santillan","marcos_trainer","381475948","conectado",R.drawable.ejemplo,30,5));
        entrenadores.add(new Entrenador("Ana","Guzman","ifbb_anaguz","3815963123","conectado",R.drawable.ejemplo2,27,3));
        entrenadores.add(new Entrenador("Pablo","Cortez","pablofit_gym","3813914257","desconectado",R.drawable.ejemplo3,29,7));
        entrenadores.add(new Entrenador("Rocio","Alderete","ro_fit_alde","3816198857","conectado",R.drawable.ejemplo4,26,4));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        listaMiniEntrenadores = view.findViewById(R.id.rvminicards);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        listaMiniEntrenadores.setLayoutManager(llm);

        iniciarEntrenadores();
        iniciarAdapter();


        return view;
    }

    public void iniciarAdapter(){
        MiniEntrenadorAdapter ia = new MiniEntrenadorAdapter(entrenadores);
        listaMiniEntrenadores.setAdapter(ia);
    }
}