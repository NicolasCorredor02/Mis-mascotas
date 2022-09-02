package com.uniminuto.miscontactos;

public class Contacto {
    private String nombre;
    private String telefono;
    private String email;
    private int foto;
    private boolean fav;

    //Constructor con parametros basicos para su creacion
    public Contacto(String nombre, String telefono, String email, int foto,boolean fav) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email=email;
        this.foto=foto;
        this.fav=fav;
    }


    //Metodos Get and Set de atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public boolean getFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }
}
