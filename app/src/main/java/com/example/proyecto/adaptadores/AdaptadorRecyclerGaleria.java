package com.example.proyecto.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyecto.R;
import com.example.proyecto.model.Foto;

import java.util.List;

public class AdaptadorRecyclerGaleria extends RecyclerView.Adapter<AdaptadorRecyclerGaleria.MiViewHolder> {

    private Context contexto;
    private List<Foto> listaFotos;

    public AdaptadorRecyclerGaleria(Context contexto, List<Foto> listaFotos) {
        this.contexto = contexto;
        this.listaFotos = listaFotos;
    }


    @NonNull
    @Override
    public MiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(contexto).inflate(R.layout.item_foto, parent, false);
        return new MiViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull MiViewHolder holder, int position) {
        Foto fotoActual = listaFotos.get(position);

        holder.tvTitulo.setText(fotoActual.getTitulo());
        Glide.with(contexto)
                .load(fotoActual.getRecursoImagen())
                .into(holder.ivFoto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(contexto, "Has seleccionado: " + fotoActual.getTitulo(), Toast.LENGTH_SHORT).show();

                android.app.Dialog dialog = new android.app.Dialog(contexto);
                dialog.setContentView(R.layout.dialog_imagen);

                ImageView ivDialog = dialog.findViewById(R.id.ivDialogFoto);
                Glide.with(contexto).load(fotoActual.getRecursoImagen()).into(ivDialog);

                ivDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaFotos.size();
    }

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