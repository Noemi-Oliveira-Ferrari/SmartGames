package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Console;
import br.senai.sp.smartgames.repository.ConsoleRepository;


@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/consoles")
public class ConsoleResource {
	
	@Autowired
	private ConsoleRepository consoleRepository;
	
	@GetMapping
	public List<Console> getConsoles(){
		return consoleRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Console> getConsoleById(@PathVariable Long id) {
		return consoleRepository.findById(id);
	}
	

}
