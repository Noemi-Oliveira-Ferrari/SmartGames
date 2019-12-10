package br.senai.sp.smartgames.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senai.sp.smartgames.model.Coordenadas;
import br.senai.sp.smartgames.repository.CoordenadasRepository;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/coordenadas")
public class CoordenadasResource {

	@Autowired
	private CoordenadasRepository coordenadasRepository;
	
	@GetMapping
	public List<Coordenadas> getCoordenadas(){
		return coordenadasRepository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Optional<Coordenadas> getCoordenadasById(@PathVariable Long id) {
		return coordenadasRepository.findById(id);
	}
}
	

