package br.senai.sp.smartgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_coordenadas")
public class Coordenadas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCoordenadas;

	@NotNull
	private String longitude;

	@NotNull
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
