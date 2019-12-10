package br.senai.sp.smartgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_genero")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGenero;
	@NotNull
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
		return "Genero [idGenero=" + idGenero + ", tituloGenero=" + tituloGenero + "]";
	}

}
