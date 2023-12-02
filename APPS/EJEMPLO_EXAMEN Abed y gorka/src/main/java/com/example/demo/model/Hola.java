package com.example.demo.model;

public class Hola {
    private String nombre;
    private String email;
    private String contracena;
    private String rol;
    private Integer id;

    public Hola() {
    }

    public Hola(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContracena() {
        return contracena;
    }

    public void setContracena(String contracena) {
        this.contracena = contracena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Hola [nombre=" + nombre + ", email=" + email + ", contracena=" + contracena + ", rol=" + rol + ", id="
                + id + "]";
    }

}
