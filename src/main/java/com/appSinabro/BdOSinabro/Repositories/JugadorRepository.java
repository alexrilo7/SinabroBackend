package com.appSinabro.BdOSinabro.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appSinabro.BdOSinabro.model.Jugador;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Long>{
	
}
