package com.example.supergym;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String email,password,telefono;
    private Boolean rutinaasignada;

   public Usuario(String email, String password, String telefono){
        this.email = email;
        this.password = password;
        this.telefono = telefono;
   }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRutinaasignada(Boolean rutinaasignada) {
        this.rutinaasignada = rutinaasignada;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getRutinaasignada() {
        return rutinaasignada;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() { return telefono; }
}
