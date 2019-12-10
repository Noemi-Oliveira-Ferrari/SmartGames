package br.senai.sp.smartgames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senai.sp.smartgames.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

	@Query("Select j from Jogo j where j.tituloJogo like %?1%")
	public List<Jogo> findByTituloJogo(String tituloJogo);
}
