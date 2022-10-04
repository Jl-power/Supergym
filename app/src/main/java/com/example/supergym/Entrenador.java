package com.example.supergym;

public class Entrenador {

    private String nombre,apellido,instagram,whatsapp,estado;
    private int foto,edad,experiencia;

    public Entrenador() {
    }


    public Entrenador(String nombre,String apellido, String instagram, String whatsapp, String estado, int foto, int edad, int experiencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
        this.estado = estado;
        this.foto = foto;
        this.edad = edad;
        this.experiencia = experiencia;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
