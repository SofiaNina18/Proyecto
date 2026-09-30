package com.example.proyecto.bbdd;


import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Edificio.class}, version = 1, exportSchema = false)
public abstract class BDExamen extends RoomDatabase {

    private static final String LOG_TAG = BDExamen.class.getSimpleName();

    private static final String DATABASE_NAME = "BDExamen";
    private static final Object LOCK = new Object();
    private static BDExamen sInstance;

    public static BDExamen getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creando la base de datos");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                                BDExamen.class, DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return sInstance;
    }

    public abstract EdificioDao edificioDao();
}
