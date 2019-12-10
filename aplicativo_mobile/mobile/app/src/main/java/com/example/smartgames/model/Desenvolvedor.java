package com.example.smartgames.model;

import java.io.Serializable;

public class Desenvolvedor implements Serializable {

    private Long idDesenvolvedor;
    private String tituloDesenvolvedor;

    public Long getIdDesenvolvedor() {
        return idDesenvolvedor;
    }

    public void setIdDesenvolvedor(Long idDesenvolvedor) {
        this.idDesenvolvedor = idDesenvolvedor;
    }

    public String getTituloDesenvolvedor() {
        return tituloDesenvolvedor;
    }

    public void setTituloDesenvolvedor(String tituloDesenvolvedor) {
        this.tituloDesenvolvedor = tituloDesenvolvedor;
    }

    @Override
    public String toString() {
        return "Desenvolvedor{" +
                "idDesenvolvedor=" + idDesenvolvedor +
                ", tituloDesenvolvedor='" + tituloDesenvolvedor + '\'' +
                '}';
    }
}
