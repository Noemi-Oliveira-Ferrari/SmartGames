package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Genero;
import br.senai.sp.smartgames.repository.GeneroRepository;


@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/generos")
public class GeneroResource {

	@Autowired
	private GeneroRepository generoRepository;
	
	@GetMapping
	public List<Genero> getGeneros(){
		return generoRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Genero> getGeneroById(@PathVariable Long id) {
		return generoRepository.findById(id);
	}
}
