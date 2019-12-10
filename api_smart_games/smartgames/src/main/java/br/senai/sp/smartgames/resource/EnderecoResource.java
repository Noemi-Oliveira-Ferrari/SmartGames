package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Endereco;
import br.senai.sp.smartgames.repository.EnderecoRepository;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@GetMapping
	public List<Endereco> getEnderecos(){
		return enderecoRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Endereco> getEnderecoById(@PathVariable Long id) {
		return enderecoRepository.findById(id);
	}
	
}
