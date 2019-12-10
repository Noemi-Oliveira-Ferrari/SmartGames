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
@Table(name = "tbl_jogo")
public class Jogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idJogo;
	@NotNull
	private String tituloJogo;
	@NotNull
	private String descricao;
	@NotNull
	private int idade;
	@NotNull
	private String anoLancamento;

	@NotNull
	private String fotoWeb;

	@NotNull
	private String fotoMobile;

	@NotNull
	private int avaliacao;
	
	@NotNull
	private Double preco;

	@NotNull
	@OneToOne
	@JoinColumn(name = "idLoja")
	private Loja loja;

	@NotNull
	@OneToOne
	@JoinColumn(name = "idDesenvolvedor")
	private Desenvolvedor desenvolvedor;

	@NotNull
	@OneToOne
	@JoinColumn(name = "idGenero")
	private Genero genero;

	@NotNull
	@OneToOne
	@JoinColumn(name = "idConsole")
	private Console console;

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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Jogo [idJogo=" + idJogo + ", tituloJogo=" + tituloJogo + ", descricao=" + descricao + ", idade=" + idade
				+ ", anoLancamento=" + anoLancamento + ", fotoWeb=" + fotoWeb + ", fotoMobile=" + fotoMobile
				+ ", avaliacao=" + avaliacao + ", preco=" + preco + ", loja=" + loja + ", desenvolvedor="
				+ desenvolvedor + ", genero=" + genero + ", console=" + console + "]";
	}

	

}
