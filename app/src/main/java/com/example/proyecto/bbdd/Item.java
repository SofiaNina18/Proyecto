package com.example.proyecto.bbdd;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "mi_tabla")
public class Item {

    @PrimaryKey(autoGenerate = true)
    public int id;

    // Cambia "nombre_dato" por lo que te pida el examen (ej: "titulo", "usuario")
    @ColumnInfo(name = "nombre_dato")
    public String nombre;

    // Constructor vacío (Room lo necesita a veces)
    public Item() {}

    // Constructor para que te sea fácil crear el objeto mañana
    public Item(String nombre) {
        this.nombre = nombre;
    }
}