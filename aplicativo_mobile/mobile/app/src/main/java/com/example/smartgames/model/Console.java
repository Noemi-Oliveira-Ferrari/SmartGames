package com.example.smartgames.model;

import java.io.Serializable;

public class Console implements Serializable {

    private Long idConsole;
    private String tituloConsole;

    public Long getIdConsole() {
        return idConsole;
    }

    public void setIdConsole(Long idConsole) {
        this.idConsole = idConsole;
    }

    public String getTituloConsole() {
        return tituloConsole;
    }

    public void setTituloConsole(String tituloConsole) {
        this.tituloConsole = tituloConsole;
    }

    @Override
    public String toString() {
        return "Console{" +
                "idConsole=" + idConsole +
                ", tituloConsole='" + tituloConsole + '\'' +
                '}';
    }
}
