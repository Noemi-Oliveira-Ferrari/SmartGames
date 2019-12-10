package com.example.smartgames.model;

import java.io.Serializable;

public class Coordenadas implements Serializable {

    private Long idCoordenadas;
    private String longitude;
    private String latitude;

    public Long getIdCoordenadas() {
        return idCoordenadas;
    }

    public void setIdCoordenadas(Long idCoordenadas) {
        this.idCoordenadas = idCoordenadas;
    }


    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordenadas [idCoordenadas=" + idCoordenadas + ", longitude=" + longitude + ", latitude=" + latitude
                + "]";
    }

}
