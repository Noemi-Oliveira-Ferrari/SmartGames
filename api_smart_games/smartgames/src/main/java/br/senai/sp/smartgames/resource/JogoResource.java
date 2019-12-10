package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Jogo;
import br.senai.sp.smartgames.repository.JogoRepository;


@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/jogos")
public class JogoResource {
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@GetMapping
	public List<Jogo> getJogos(){
		return jogoRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Jogo> getJogoById(@PathVariable Long id) {
		return jogoRepository.findById(id);
	}
	
	@GetMapping("titulo/{tituloJogo}")
	public List<Jogo> getJogosByName(@PathVariable String tituloJogo){
		return jogoRepository.findByTituloJogo(tituloJogo);
	}
}
