package com.example.smartgames.model;

import java.io.Serializable;

public class Endereco implements Serializable {

    private Long idEndereco;
    private String logradouro;
    private String localMapa;
    private UF uf;
    private String bairro;
    private int numero;
    private Coordenadas coordenadas;

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLocalMapa() {
        return localMapa;
    }

    public void setLocalMapa(String localMapa) {
        this.localMapa = localMapa;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Coordenadas getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenadas coordenadas) {
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "idEndereco=" + idEndereco +
                ", logradouro='" + logradouro + '\'' +
                ", localMapa='" + localMapa + '\'' +
                ", uf=" + uf +
                ", bairro='" + bairro + '\'' +
                ", numero=" + numero +
                ", coordenadas=" + coordenadas +
                '}';
    }
}
