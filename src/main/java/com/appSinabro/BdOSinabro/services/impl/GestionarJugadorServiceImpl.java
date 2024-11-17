package com.appSinabro.BdOSinabro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appSinabro.BdOSinabro.Dto.JugadorDTO;
import com.appSinabro.BdOSinabro.mapping.JugadorMapper;
import com.appSinabro.BdOSinabro.model.Jugador;
import com.appSinabro.BdOSinabro.services.BDDService;
import com.appSinabro.BdOSinabro.services.GestionarJugadorService;

@Service
public class GestionarJugadorServiceImpl implements GestionarJugadorService {

	@Autowired
	BDDService bdd;
	
	@Autowired
	JugadorMapper mapperJugador;
	
	@Override
	public JugadorDTO votarJugador(Long idJugador, float valoracion, int goles, int asistencias) {
		try {
			List<Jugador> jugadores = bdd.recuperarJugadores();
			Jugador jugador = jugadores.stream().filter(juga -> idJugador == juga.getId()).findFirst().get();
			float valoracionFinal = (jugador.getValoracion() + valoracion)/2;
			jugador.setValoracion(valoracionFinal);
			jugador.setGoles(jugador.getGoles()+goles);
			jugador.setAsistencias(jugador.getAsistencias()+asistencias);
			Jugador jugadorVotado = bdd.votarJugador(jugador);
			return mapperJugador.jugadorToJugadorDTO(jugadorVotado);
		} catch(Exception e) {
			return null;
		}
		
	}

	
	@Override
	public List<JugadorDTO> recuperarJugadores() {
		try {
			List<Jugador> jugadores = bdd.recuperarJugadores();
			return mapperJugador.jugadoresToJugadorDTOs(jugadores);
		} catch(Exception e) {
			return null;
		}
	}

}
