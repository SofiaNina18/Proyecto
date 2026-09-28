package com.example.proyecto.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.proyecto.R;
import com.example.proyecto.model.Curso;

import java.util.ArrayList;

public class InicioFragment extends Fragment {
    private ListView lvCurso;
    private ArrayList<Curso> listaCursos;

    public InicioFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        lvCurso = view.findViewById(R.id.lvCursos);
        cargarDatos();
        ArrayAdapter<Curso> adaptador = new ArrayAdapter<>(
          requireContext(), R.layout.item_curso, listaCursos
        );
        lvCurso.setAdapter(adaptador);
    }

    private void cargarDatos() {
        listaCursos = new ArrayList<>();
        listaCursos.add(new Curso("DAM 1"));
        listaCursos.add(new Curso("DAM 2"));
        listaCursos.add(new Curso("SMR 1"));
        listaCursos.add(new Curso("SMR 2"));
        listaCursos.add(new Curso("GA 1"));
        listaCursos.add(new Curso("GA 2"));
    }


}
















