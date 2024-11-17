package com.appSinabro.BdOSinabro.services.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appSinabro.BdOSinabro.Dto.VotoDTO;
import com.appSinabro.BdOSinabro.mapping.JugadorMapper;
import com.appSinabro.BdOSinabro.mapping.LoginRequestMapper;
import com.appSinabro.BdOSinabro.mapping.PartidoMapper;
import com.appSinabro.BdOSinabro.mapping.VotoMapper;
import com.appSinabro.BdOSinabro.model.Jugador;
import com.appSinabro.BdOSinabro.model.LoginRequest;
import com.appSinabro.BdOSinabro.model.Partido;
import com.appSinabro.BdOSinabro.model.Voto;
import com.appSinabro.BdOSinabro.services.BDDService;
import com.appSinabro.BdOSinabro.services.VotoService;

@Service
public class VotoServiceImpl implements VotoService {

	@Autowired
	BDDService bddService;
	
	@Autowired
	JugadorMapper jugadorMapper;
	
	@Autowired
	LoginRequestMapper loginMapper;
	
	@Autowired
	PartidoMapper partidoMapper;
	
	@Autowired
	VotoMapper votoMapper;
	
	@Override
	public VotoDTO annadirVotoJugador(VotoDTO voto) throws SQLException, IOException {
		Jugador jugadorMapeado = jugadorMapper.jugadorDTOToJugador(voto.getJugador());
		Partido partidoMapeado = partidoMapper.partidoDTOToPartido(voto.getPartido());
		LoginRequest usuarioMapeado = loginMapper.loginRequestDTOToLoginRequest(voto.getUsuario());
		Voto votoMapeado = votoMapper.votoDTOToVoto(voto);
		Voto votoBDD = bddService.annadirVotoJugador(partidoMapeado, usuarioMapeado, jugadorMapeado, votoMapeado);
		return votoMapper.votoToVotoDTO(votoBDD);
	}

}
