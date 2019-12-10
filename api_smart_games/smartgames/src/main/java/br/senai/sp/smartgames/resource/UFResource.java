package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.UF;
import br.senai.sp.smartgames.repository.UFRepository;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/ufs")
public class UFResource {

	@Autowired
	private UFRepository ufRepository;
	
	@GetMapping
	public List<UF> getUFs(){
		return ufRepository.findAll();
	}

	@GetMapping("/{uf}")
	public UF getUFByUf(@PathVariable String uf) {
		return ufRepository.findByUf(uf);		
	}
	
	@GetMapping("/id/{id}")
	public Optional<UF> getUFById(@PathVariable Long id) {
		return ufRepository.findById(id);
	}
	
}
