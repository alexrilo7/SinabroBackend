package com.appSinabro.BdOSinabro.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appSinabro.BdOSinabro.model.Jugador;
import com.appSinabro.BdOSinabro.model.Voto;

public interface VotoRepository extends JpaRepository<Voto, Long>{

	public Voto findByUsuarioEmailAndJugadorIdAndPartidoId(String email, Long jugadorId, Long partidoId);
	public List<Voto> findByJugador(Jugador jugador);
}
