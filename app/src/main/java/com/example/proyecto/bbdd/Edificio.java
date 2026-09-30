package com.example.proyecto.bbdd;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Edificio")
public class Edificio {
    @PrimaryKey(autoGenerate = true)
    public int ID;

    @ColumnInfo(name = "Nombre")
    public String Nombre;

    @ColumnInfo(name = "URL")
    public String URL;

    public Edificio(String Nombre, String URL) {
        this.Nombre = Nombre;
        this.URL = URL;
    }
}