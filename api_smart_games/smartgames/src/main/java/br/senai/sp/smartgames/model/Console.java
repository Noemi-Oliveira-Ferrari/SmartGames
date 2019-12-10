package br.senai.sp.smartgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_console")
public class Console {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsole;
	
	@NotNull
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
		return "Console [idConsole=" + idConsole + ", tituloConsole=" + tituloConsole + "]";
	}

}
