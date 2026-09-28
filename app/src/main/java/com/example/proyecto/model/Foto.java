package com.example.proyecto.model;

public class Foto {
    private String titulo;
    private int recursoImagen;

    public Foto(String titulo, int recursoImagen) {
        this.titulo = titulo;
        this.recursoImagen = recursoImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getRecursoImagen() {
        return recursoImagen;
    }

    public void setRecursoImagen(int recursoImagen) {
        this.recursoImagen = recursoImagen;
    }
}
