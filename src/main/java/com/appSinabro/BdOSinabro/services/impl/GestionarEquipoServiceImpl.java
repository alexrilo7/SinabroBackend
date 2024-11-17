package com.appSinabro.BdOSinabro.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appSinabro.BdOSinabro.Dto.EquipoDTO;
import com.appSinabro.BdOSinabro.mapping.EquipoMapper;
import com.appSinabro.BdOSinabro.model.Equipo;
import com.appSinabro.BdOSinabro.model.Partido;
import com.appSinabro.BdOSinabro.services.BDDService;
import com.appSinabro.BdOSinabro.services.GestionarEquipoService;

@Service
public class GestionarEquipoServiceImpl implements GestionarEquipoService {

	@Autowired
	BDDService bdd;

	@Autowired
	EquipoMapper mapperEquipo;

	@Override
	public List<EquipoDTO> recuperarEquipos() {
		try {
			List<Equipo> equipos = bdd.recuperarEquipos();
			return mapperEquipo.equiposToEquipoDTOs(equipos);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public EquipoDTO recuperarEquipo(EquipoDTO equipo) {
		try {
			Equipo equipoBdd = bdd.recuperarEquipo(mapperEquipo.equipoDTOToEquipo(equipo));
			return mapperEquipo.equipoToEquipoDTO(equipoBdd);
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Partido> recuperarPartidosPorEquipo(Long equipoId) {
		try {
			return bdd.recuperarPartidosPorEquipo(equipoId);
		} catch(Exception e) {
			return null;
		}
	}

}
