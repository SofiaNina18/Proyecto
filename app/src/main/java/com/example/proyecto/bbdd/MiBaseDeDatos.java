package com.example.proyecto.bbdd;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Item.class}, version = 1)
public abstract class MiBaseDeDatos extends RoomDatabase {

    public abstract ItemDao itemDao();

    private static volatile MiBaseDeDatos INSTANCE;

    public static MiBaseDeDatos getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (MiBaseDeDatos.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MiBaseDeDatos.class, "base_datos_examen.db")
                            // .allowMainThreadQueries() // Descomenta esto SOLO si el profesor os deja hacerlo sin hilos (te salva la vida en el examen)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}