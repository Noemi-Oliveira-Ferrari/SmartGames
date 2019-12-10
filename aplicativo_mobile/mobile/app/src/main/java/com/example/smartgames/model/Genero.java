package com.example.smartgames.model;

import java.io.Serializable;

public class Genero implements Serializable {

    private Long idGenero;
    private String tituloGenero;

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public String getTituloGenero() {
        return tituloGenero;
    }

    public void setTituloGenero(String tituloGenero) {
        this.tituloGenero = tituloGenero;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "idGenero=" + idGenero +
                ", tituloGenero='" + tituloGenero + '\'' +
                '}';
    }
}
