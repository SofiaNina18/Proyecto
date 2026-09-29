package com.example.proyecto.bbdd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface ItemDao {

    @Insert
    void insertar(Item item);

    @Query("SELECT * FROM mi_tabla")
    List<Item> obtenerTodos();

    // Si necesitas borrar todo de golpe por si acaso:
    @Query("DELETE FROM mi_tabla")
    void borrarTodo();
}