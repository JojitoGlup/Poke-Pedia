package com.mycompany.proyecto.pokepedia;

public class Pokemon {

    private String nombre;
    private String ilustracion;
    private String tipo;
    private String habilidad;
    private String descripcionHabilidad;
    private String ataque;
    private int danioAtaque;
    private String descripcionAtaque;

    public Pokemon(String nombre, String ilustracion, String tipo, String habilidad,
                   String descripcionHabilidad, String ataque, int danioAtaque,
                   String descripcionAtaque) {
        this.nombre = nombre;
        this.ilustracion = ilustracion;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.descripcionHabilidad = descripcionHabilidad;
        this.ataque = ataque;
        this.danioAtaque = danioAtaque;
        this.descripcionAtaque = descripcionAtaque;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIlustracion() {
        return ilustracion;
    }

    public void setIlustracion(String ilustracion) {
        this.ilustracion = ilustracion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public String getDescripcionHabilidad() {
        return descripcionHabilidad;
    }

    public void setDescripcionHabilidad(String descripcionHabilidad) {
        this.descripcionHabilidad = descripcionHabilidad;
    }

    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public int getDanioAtaque() {
        return danioAtaque;
    }

    public void setDanioAtaque(int danioAtaque) {
        this.danioAtaque = danioAtaque;
    }

    public String getDescripcionAtaque() {
        return descripcionAtaque;
    }

    public void setDescripcionAtaque(String descripcionAtaque) {
        this.descripcionAtaque = descripcionAtaque;
    }
}
