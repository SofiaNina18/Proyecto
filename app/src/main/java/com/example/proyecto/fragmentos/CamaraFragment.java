package com.example.proyecto.fragmentos;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyecto.adaptadores.AdaptadorCamara;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import com.example.proyecto.R;

public class CamaraFragment extends Fragment {
    private RecyclerView recyclerView;
    private AdaptadorCamara adaptador;
    private List<File> listaArchivos = new ArrayList<>();

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                    Bitmap imageBitmap = (Bitmap) result.getData().getExtras().get("data");
                    guardarEnCarpetaExamen(imageBitmap);
                    cargarFotos();
                }
            });

    public CamaraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_camara, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerCamara);
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        Button btnCámara = view.findViewById(R.id.btnAbrirCamara);
        btnCámara.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            launcher.launch(intent);
        });

        cargarFotos();
    }

    private void guardarEnCarpetaExamen(Bitmap bitmap) {
        File dir = new File(requireContext().getFilesDir(), "examen");
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fecha = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String nombreFoto = "foto_" + fecha + ".jpg";

        File archivo = new File(dir, nombreFoto);
        try {
            FileOutputStream fos = new FileOutputStream(archivo);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cargarFotos() {
        File dir = new File(requireContext().getFilesDir(), "examen");
        if (dir.exists() && dir.listFiles() != null) {
            listaArchivos = Arrays.asList(dir.listFiles());
        }
        adaptador = new AdaptadorCamara(requireContext(), listaArchivos);
        recyclerView.setAdapter(adaptador);
    }
}
