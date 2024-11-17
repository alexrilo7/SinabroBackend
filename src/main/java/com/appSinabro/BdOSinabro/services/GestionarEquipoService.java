package com.appSinabro.BdOSinabro.services;

import java.util.List;

import com.appSinabro.BdOSinabro.Dto.EquipoDTO;
import com.appSinabro.BdOSinabro.model.Partido;

public interface GestionarEquipoService {
	public List<EquipoDTO> recuperarEquipos();
	public EquipoDTO recuperarEquipo(EquipoDTO equipo);
	public List<Partido> recuperarPartidosPorEquipo(Long equipoId);
}
