package br.senai.sp.smartgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.senai.sp.smartgames.model.UF;

public interface UFRepository extends JpaRepository<UF, Long>{
	
	@Query("SELECT u FROM UF u WHERE u.uf = ?1")
	public UF findByUf(String uf);

}
