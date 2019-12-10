package br.senai.sp.smartgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_desenvolvedor")
public class Desenvolvedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDesenvolvedor;
	@NotNull
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
		return "Desenvolvedor [idDesenvolvedor=" + idDesenvolvedor + ", tituloDesenvolvedor=" + tituloDesenvolvedor
				+ "]";
	}

}
