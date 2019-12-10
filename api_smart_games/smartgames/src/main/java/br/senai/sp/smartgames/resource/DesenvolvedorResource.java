package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Desenvolvedor;
import br.senai.sp.smartgames.repository.DesenvolvedorRepository;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/desenvolvedores")
public class DesenvolvedorResource {
	
	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;
	
	@GetMapping
	public List<Desenvolvedor> getDesenvolvedores(){
		return desenvolvedorRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Desenvolvedor> getDesenvolvedorById(@PathVariable Long id) {
		return desenvolvedorRepository.findById(id);
	}
}
