package com.example.proyecto.fragmentos;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.proyecto.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MapaFragment extends Fragment  {
    private WebView webViewMapa;

    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mapa, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        webViewMapa = view.findViewById(R.id.webViewMapa);

        WebSettings webSettings = webViewMapa.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);

        webViewMapa.setWebViewClient(new WebViewClient());

        String htmlMapa = "<html><body style='margin:0;padding:0;'><iframe width='100%' height='100%' frameborder='0' style='border:0' src='https://maps.google.com/maps?q=43.2713,-2.9489&z=16&output=embed' allowfullscreen></iframe></body></html>";

        webViewMapa.loadDataWithBaseURL(null, htmlMapa, "text/html", "UTF-8", null);
    }


}





















