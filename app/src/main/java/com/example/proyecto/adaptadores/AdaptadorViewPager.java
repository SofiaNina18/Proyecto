package com.example.proyecto.adaptadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.proyecto.fragmentos.ExteriorFragment;
import com.example.proyecto.fragmentos.GaleriaFragment;
import com.example.proyecto.fragmentos.InteriorFragment;

public class AdaptadorViewPager extends FragmentStateAdapter {

    public AdaptadorViewPager(@NonNull GaleriaFragment fragmentGaleria) {
        super(fragmentGaleria);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new InteriorFragment();
        }
        return new ExteriorFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
