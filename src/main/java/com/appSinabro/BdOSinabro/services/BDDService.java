package com.appSinabro.BdOSinabro.services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.model.Equipo;
import com.appSinabro.BdOSinabro.model.Jugador;
import com.appSinabro.BdOSinabro.model.LoginRequest;
import com.appSinabro.BdOSinabro.model.Partido;
import com.appSinabro.BdOSinabro.model.Voto;

public interface BDDService {
	public List<Jugador> recuperarJugadores();
	public List<Equipo> recuperarEquipos();
	public boolean existeUsuarioYPassword(LoginRequestDTO loginReq);
	public Jugador recuperarJugador(Jugador jugador);
	public Jugador votarJugador(Jugador jugador);
	public void registrarUsuario(LoginRequest usuario);
	public Equipo recuperarEquipo(Equipo equipo);
	public List<Partido> recuperarPartidosPorEquipo(Long equipoId);
	public Voto annadirVotoJugador(Partido partido, LoginRequest usuario, Jugador jugador, Voto voto) throws SQLException, IOException ;
}
