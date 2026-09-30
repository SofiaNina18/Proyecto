package com.example.proyecto.bbdd;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface EdificioDao {
    @Insert
    void insertar(Edificio edificio);

    @Query("SELECT * FROM Edificio")
    List<Edificio> obtenerTodos();


}
