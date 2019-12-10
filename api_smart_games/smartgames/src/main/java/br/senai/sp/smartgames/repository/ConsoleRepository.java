package br.senai.sp.smartgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senai.sp.smartgames.model.Console;

public interface ConsoleRepository extends JpaRepository<Console, Long> {

	//@Query("SELECT c FROM Console c WHERE c.idConsole = ?1")
	//public Console findByIdConsole(String idConsole);
	
	
}
