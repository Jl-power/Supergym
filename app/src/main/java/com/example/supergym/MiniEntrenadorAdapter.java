package com.example.supergym;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MiniEntrenadorAdapter extends RecyclerView.Adapter<MiniEntrenadorAdapter.EntrenadorViewHolder> {
    ArrayList<Entrenador> entrenadores;

    public MiniEntrenadorAdapter(ArrayList<Entrenador> m){
        this.entrenadores = m;
    }

    @NonNull
    @Override
    public EntrenadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.minitarjeta_entrenador,parent,false);
        return new EntrenadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EntrenadorViewHolder holder, int position) {
        Entrenador entrenador = entrenadores.get(position);
        holder.foto.setImageResource(entrenador.getFoto());
        if(entrenador.getEstado().equalsIgnoreCase("conectado")){
            holder.estado.setBackgroundResource(R.color.green);
        }
        else{
            holder.estado.setBackgroundResource(R.color.red);
        }
    }

    @Override
    public int getItemCount() {
        return entrenadores.size();
    }

    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder{

        private final ImageView foto;
        private final TextView estado;


        public EntrenadorViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.minicard);
            estado = itemView.findViewById(R.id.textViewestado);
        }
    }
}
