package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Loja;
import br.senai.sp.smartgames.repository.LojaRepository;


@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/lojas")
public class LojaResource {

	@Autowired
	private LojaRepository lojaRepository;
	
	@GetMapping
	public List<Loja> getLojas(){
		return lojaRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Loja> getLojaById(@PathVariable Long id) {
		return lojaRepository.findById(id);
	}
	
}
