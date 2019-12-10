package br.senai.sp.smartgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author ALEXANDRE
 *
 */
@Entity
@Table(name = "tbl_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	@NotNull
	private String logradouro;
	@NotNull
	private String localMapa;

	@OneToOne
	@JoinColumn(name = "idUf")
	private UF uf;
	

	@OneToOne
	@JoinColumn(name = "idCoordenadas")
	private Coordenadas coordenadas;
	
	private String bairro;
	
	private int numero;

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
		return "Endereco [idEndereco=" + idEndereco + ", logradouro=" + logradouro + ", localMapa=" + localMapa
				+ ", uf=" + uf + ", coordenadas=" + coordenadas + ", bairro=" + bairro + ", numero=" + numero + "]";
	}

	
	

	

}
