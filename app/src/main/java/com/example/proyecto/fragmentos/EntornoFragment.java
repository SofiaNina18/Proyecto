package com.example.proyecto.fragmentos;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyecto.adaptadores.AdaptadorEntorno;
import com.example.proyecto.bbdd.BDExamen;
import com.example.proyecto.bbdd.Edificio;
import java.util.List;

import com.example.proyecto.R;



public class EntornoFragment extends Fragment {


    public EntornoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entorno, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerEntorno);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        BDExamen db = BDExamen.getInstance(requireContext());

        if (db.edificioDao().obtenerTodos().isEmpty()) {

                String urlWeb = "https://th.bing.com/th/id/OIP.rH5irdjFQeM7OY4_wFUDnAAAAA?w=161&h=121&c=7&r=0&o=7&pid=1.7&rm=3";

                db.edificioDao().insertar(new Edificio("Deusto 1", urlWeb));
                db.edificioDao().insertar(new Edificio("Deusto 2", urlWeb));

        }

        List<Edificio> lista = db.edificioDao().obtenerTodos();
        recyclerView.setAdapter(new AdaptadorEntorno(requireContext(), lista));
    }
}
