package com.example.proyecto.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.proyecto.R;
import java.io.File;
import java.util.List;

public class AdaptadorCamara extends RecyclerView.Adapter<AdaptadorCamara.MiViewHolder> {
    private Context contexto;
    private List<File> listaArchivos;

    public AdaptadorCamara(Context contexto, List<File> listaArchivos) {
        this.contexto = contexto;
        this.listaArchivos = listaArchivos;
    }

    @NonNull @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexto).inflate(R.layout.item_foto, parent, false);
        return new MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        File archivo = listaArchivos.get(position);
        holder.tvTitulo.setText(archivo.getName());
        Glide.with(contexto).load(archivo).into(holder.ivFoto);
    }

    @Override public int getItemCount() { return listaArchivos.size(); }

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvTitulo;
        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFotoItem);
            tvTitulo = itemView.findViewById(R.id.tvTituloFoto);
        }
    }
}