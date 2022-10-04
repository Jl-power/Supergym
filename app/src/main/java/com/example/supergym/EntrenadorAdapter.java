package com.example.supergym;

import static android.graphics.Color.parseColor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EntrenadorAdapter extends RecyclerView.Adapter<EntrenadorAdapter.EntrenadorViewHolder> {
    ArrayList<Entrenador> entrenadores;

    public EntrenadorAdapter(ArrayList<Entrenador> m){
        this.entrenadores = m;
    }

    @NonNull
    @Override
    public EntrenadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_entrenador,parent,false);
        return new EntrenadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EntrenadorViewHolder holder, int position) {
        Entrenador entrenador = entrenadores.get(position);
        holder.foto.setImageResource(entrenador.getFoto());
        holder.buttondescripcion.setText("Hola mi nombre es " + entrenador.getNombre() + " " + entrenador.getApellido() +
                "\nEdad: " + entrenador.getEdad() +
                "\nExperiencia: " + entrenador.getExperiencia() +
                "\nIG: " + entrenador.getInstagram() +
                "\nWP: " + entrenador.getWhatsapp());
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
        private final Button buttonsolicitar,buttondescripcion;
        private final TextView estado;


        public EntrenadorViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.card_foto);
            buttonsolicitar = itemView.findViewById(R.id.buttonsolicitar);
            buttondescripcion = itemView.findViewById(R.id.descripcion);
            estado = itemView.findViewById(R.id.estado);

        }
    }
}
