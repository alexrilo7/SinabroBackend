package com.appSinabro.BdOSinabro.services;

import java.util.List;

import com.appSinabro.BdOSinabro.Dto.JugadorDTO;

public interface GestionarJugadorService {
	public JugadorDTO votarJugador(Long idJugador, float valoracion, int goles, int asistencias);
	public List<JugadorDTO> recuperarJugadores();
	
}
