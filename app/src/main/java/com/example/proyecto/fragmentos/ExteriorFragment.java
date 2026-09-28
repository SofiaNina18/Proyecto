package com.example.proyecto.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto.R;
import com.example.proyecto.adaptadores.AdaptadorRecyclerGaleria;
import com.example.proyecto.model.Foto;

import java.util.ArrayList;
import java.util.List;


public class ExteriorFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Foto> listaFotosExterior;

    public ExteriorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exterior, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerExterior);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        cargarDatosInterior();

        AdaptadorRecyclerGaleria adaptador = new AdaptadorRecyclerGaleria(requireContext(), listaFotosExterior);
        recyclerView.setAdapter(adaptador);
    }

    private void cargarDatosInterior() {
        listaFotosExterior = new ArrayList<>();
        listaFotosExterior.add(new Foto("Texto Exterior 1", R.drawable.logo_almi));
        listaFotosExterior.add(new Foto("Texto Exterior 2", R.drawable.logo_almi));
        listaFotosExterior.add(new Foto("Texto Exterior 3", R.drawable.logo_almi));
        listaFotosExterior.add(new Foto("Texto Exterior 4", R.drawable.logo_almi));
    }
}