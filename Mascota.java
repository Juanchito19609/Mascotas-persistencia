package com.example.mascotas.model;

public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int rating;

    public Mascota(int id, String nombre, int foto, int rating) {
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFoto() {
        return foto;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
