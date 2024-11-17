package com.appSinabro.BdOSinabro.services.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.Repositories.EquipoRepository;
import com.appSinabro.BdOSinabro.Repositories.JugadorRepository;
import com.appSinabro.BdOSinabro.Repositories.LoginReqRepository;
import com.appSinabro.BdOSinabro.Repositories.PartidoRepository;
import com.appSinabro.BdOSinabro.Repositories.VotoRepository;
import com.appSinabro.BdOSinabro.model.Equipo;
import com.appSinabro.BdOSinabro.model.Jugador;
import com.appSinabro.BdOSinabro.model.LoginRequest;
import com.appSinabro.BdOSinabro.model.Partido;
import com.appSinabro.BdOSinabro.model.Voto;
import com.appSinabro.BdOSinabro.services.BDDService;

import jakarta.transaction.Transactional;

@Service
public class BDDServiceImpl implements BDDService {

	@Autowired
	JugadorRepository jugadorRepository;

	@Autowired
	EquipoRepository equipoRepository;

	@Autowired
	LoginReqRepository loginRepository;

	@Autowired
	PartidoRepository partidoRepository;

	@Autowired
	VotoRepository votoRepository;

	@Override
	@Transactional
	public List<Jugador> recuperarJugadores() {
		try {
			return jugadorRepository.findAll();
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	@Transactional
	public List<Equipo> recuperarEquipos() {
		try {
			List<Equipo> equipos = equipoRepository.findAll();
			// this.generarPartidos(equipos);
			return equipos;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public boolean existeUsuarioYPassword(LoginRequestDTO loginReq) {
		try {
			LoginRequest usuario = loginRepository.findById(loginReq.getEmail()).orElse(null);
			return (null != usuario) ? loginReq.getPassword().equals(usuario.getPassword()) : false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public Jugador recuperarJugador(Jugador jugador) {
		try {
			Jugador jugadorEncontrado = jugadorRepository.findById(jugador.getId()).orElse(null);
			return jugadorEncontrado;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public Jugador votarJugador(Jugador jugadorActualizado) {
		try {
			return jugadorRepository.save(jugadorActualizado);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void registrarUsuario(LoginRequest usuario) {
		try {
			loginRepository.save(usuario);
		} catch (Exception e) {
		}

	}

	@Override
	@Transactional
	public Equipo recuperarEquipo(Equipo equipo) {
		try {
			return equipoRepository.findById(equipo.getId()).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

	/*
	 * private void generarPartidos(List<Equipo> equipos) {
	 * 
	 * for (int j = 1; j < equipos.size(); j++) { // Partido de ida Partido Partido
	 * partidoIda = new Partido(); partidoIda.setEquipoLocal(equipos.get(0));
	 * partidoIda.setEquipoVisitante(equipos.get(j)); partidoIda.setTipo("ida");
	 * partidoRepository.save(partidoIda);
	 * 
	 * Partido partidoVuelta = new Partido();
	 * partidoVuelta.setEquipoLocal(equipos.get(j));
	 * partidoVuelta.setEquipoVisitante(equipos.get(0));
	 * partidoVuelta.setTipo("vuelta"); partidoRepository.save(partidoVuelta); }
	 * 
	 * }
	 */

	@Override
	@Transactional
	public List<Partido> recuperarPartidosPorEquipo(Long equipoId) {
		try {
			return partidoRepository.findByEquipoId(equipoId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Voto annadirVotoJugador(Partido partido, LoginRequest usuario, Jugador jugador, Voto voto)
			throws SQLException, IOException {
		try {
			Voto votoBDD = votoRepository.findByUsuarioEmailAndJugadorIdAndPartidoId(usuario.getEmail(),
					jugador.getId(), partido.getId());
			if (null != votoBDD) {
				return null;
			} else {
				Voto nuevoVoto = new Voto();
				nuevoVoto.setValoracion(voto.getValoracion());
				nuevoVoto.setGoles(voto.getGoles());
				nuevoVoto.setAsistencias(voto.getAsistencias());
				nuevoVoto.setUsuario(usuario);
				nuevoVoto.setPartido(partido);
				nuevoVoto.setJugador(jugador);
				Voto votoDespuesDeVotar = votoRepository.save(nuevoVoto);
				actualizarEstadisticasJugador(jugador);
				return votoDespuesDeVotar;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private void actualizarEstadisticasJugador(Jugador jugador) throws Exception {
		// Calcular las nuevas estadísticas a partir de los votos del jugador
		List<Voto> votos = votoRepository.findByJugador(jugador);

		// Calcular la nueva valoración
		double valoracionPromedio = votos.stream().mapToDouble(Voto::getValoracion).average().orElse(0.0);

		// Calcular goles y asistencias acumulados
		int totalGoles = votos.stream().mapToInt(Voto::getGoles).sum();
		int totalAsistencias = votos.stream().mapToInt(Voto::getAsistencias).sum();

		// Actualizar el jugador
		jugador.setValoracion((float) valoracionPromedio);
		jugador.setGoles(totalGoles);
		jugador.setAsistencias(totalAsistencias);

		jugadorRepository.save(jugador);
	}

}
