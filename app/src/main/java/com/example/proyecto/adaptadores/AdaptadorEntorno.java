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
import com.example.proyecto.bbdd.Edificio;
import java.util.List;

public class AdaptadorEntorno extends RecyclerView.Adapter<AdaptadorEntorno.MiViewHolder> {
    private Context contexto;
    private List<Edificio> lista;

    public AdaptadorEntorno(Context contexto, List<Edificio> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    @NonNull @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contexto).inflate(R.layout.item_foto, parent, false);
        return new MiViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Edificio ed = lista.get(position);
        holder.tvTitulo.setText(ed.Nombre);
        Glide.with(contexto).load(ed.URL).into(holder.ivFoto);
    }

    @Override public int getItemCount() { return lista.size(); }

    public static class MiViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto; TextView tvTitulo;
        public MiViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoto = itemView.findViewById(R.id.ivFotoItem);
            tvTitulo = itemView.findViewById(R.id.tvTituloFoto);
        }
    }
}