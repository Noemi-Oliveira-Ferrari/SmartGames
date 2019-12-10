package br.senai.sp.smartgames.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senai.sp.smartgames.model.Coordenadas;

public interface CoordenadasRepository extends JpaRepository<Coordenadas, Long> {

}
