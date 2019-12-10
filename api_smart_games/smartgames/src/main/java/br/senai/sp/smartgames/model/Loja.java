package br.senai.sp.smartgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_loja")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoja;
	@NotNull
	private String tituloLojaShopping;

	@NotNull
	@OneToOne
	@JoinColumn(name = "idEndereco")
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
		return "Loja [idLoja=" + idLoja + ", tituloLojaShopping=" + tituloLojaShopping + ", endereco=" + endereco + "]";
	}

}
