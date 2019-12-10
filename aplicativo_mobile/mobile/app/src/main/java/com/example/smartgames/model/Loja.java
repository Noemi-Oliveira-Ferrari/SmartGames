package com.example.smartgames.model;

import java.io.Serializable;

public class Loja implements Serializable {

    private Long idLoja;
    private String tituloLojaShopping;
    private Endereco endereco;

    public Long getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(Long idLoja) {
        this.idLoja = idLoja;
    }

    public String getTituloLojaShopping() {
        return tituloLojaShopping;
    }

    public void setTituloLojaShopping(String tituloLojaShopping) {
        this.tituloLojaShopping = tituloLojaShopping;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "idLoja=" + idLoja +
                ", tituloLojaShopping='" + tituloLojaShopping + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
