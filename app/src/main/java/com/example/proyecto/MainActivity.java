package com.example.proyecto;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.proyecto.fragmentos.GaleriaFragment;
import com.example.proyecto.fragmentos.InicioFragment;
import com.example.proyecto.fragmentos.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private BottomNavigationView bottomNavView;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawerLayout = findViewById(R.id.main);
        navView = findViewById(R.id.navView);
        bottomNavView = findViewById(R.id.bottomNavView);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.setDrawerIndicatorEnabled(true);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("App Almi");
        }



        if (savedInstanceState == null) {
            cambiarPantalla(R.id.itInicio);
            navView.setCheckedItem(R.id.itInicio);
            bottomNavView.setSelectedItemId(R.id.itInicio);
        }

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                cambiarPantalla(id);
                bottomNavView.getMenu().findItem(id).setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        bottomNavView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                cambiarPantalla(id);
                navView.setCheckedItem(id);
                return true;
            }
        });

    }
    private void cambiarPantalla(int id) {
        if (id == R.id.itInicio) {
            reemplazarFragmento(new InicioFragment());
        } else if (id == R.id.itMapa) {
            reemplazarFragmento(new MapaFragment());
        } else if (id == R.id.itGaleria) {
            reemplazarFragmento(new GaleriaFragment());
        }
    }


    private void reemplazarFragmento(Fragment fragmento) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
        transaction.replace(R.id.fragmento, fragmento);
        transaction.commit();

    }

}

























