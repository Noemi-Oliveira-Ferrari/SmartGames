package com.example.smartgames.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Jogo implements Serializable {

    private Long idJogo;
    private String tituloJogo;
    private String descricao;
    private int idade;
    private String anoLancamento;
    private String fotoWeb;
    private String fotoMobile;
    private int avaliacao;
    private Loja loja;
    private Desenvolvedor desenvolvedor;
    private Genero genero;
    private Console console;
    private Double preco;

    public Long getIdJogo() {
        return idJogo;
    }

    public void setIdJogo(Long idJogo) {
        this.idJogo = idJogo;
    }

    public String getTituloJogo() {
        return tituloJogo;
    }

    public void setTituloJogo(String tituloJogo) {
        this.tituloJogo = tituloJogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getFotoWeb() {
        return fotoWeb;
    }

    public void setFotoWeb(String fotoWeb) {
        this.fotoWeb = fotoWeb;
    }

    public String getFotoMobile() {
        return fotoMobile;
    }

    public void setFotoMobile(String fotoMobile) {
        this.fotoMobile = fotoMobile;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "idJogo=" + idJogo +
                ", tituloJogo='" + tituloJogo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", idade=" + idade +
                ", anoLancamento='" + anoLancamento + '\'' +
                ", fotoWeb='" + fotoWeb + '\'' +
                ", fotoMobile='" + fotoMobile + '\'' +
                ", avaliacao=" + avaliacao +
                ", loja=" + loja +
                ", desenvolvedor=" + desenvolvedor +
                ", genero=" + genero +
                ", console=" + console +
                ", preco=" + preco +
                '}';
    }
}

