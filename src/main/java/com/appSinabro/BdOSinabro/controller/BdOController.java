package com.appSinabro.BdOSinabro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appSinabro.BdOSinabro.Dto.EquipoDTO;
import com.appSinabro.BdOSinabro.Dto.JugadorDTO;
import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.Dto.VotoDTO;
import com.appSinabro.BdOSinabro.model.Partido;
import com.appSinabro.BdOSinabro.services.GestionarEquipoService;
import com.appSinabro.BdOSinabro.services.GestionarJugadorService;
import com.appSinabro.BdOSinabro.services.LoginService;
import com.appSinabro.BdOSinabro.services.VotoService;

@RestController
public class BdOController {

	@Autowired
	LoginService loginService;

	@Autowired
	GestionarEquipoService gestionarEquipoService;

	@Autowired
	GestionarJugadorService gestionarJugadorService;
	
	@Autowired
	VotoService votoService;

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequestDTO loginReq) {
		Map<String, String> response = new HashMap<>();
		if (loginService.login(loginReq)) {
			response.put("message", "Autenticación exitosa");
			return ResponseEntity.ok(response);
		} else {
			response.put("message", "Autenticación fallida");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
		}

	}

	@GetMapping("/recuperarEquipos")
	public ResponseEntity<List<EquipoDTO>> recuperarEquipos() {
		try {
			List<EquipoDTO> equipos = gestionarEquipoService.recuperarEquipos();
			return ResponseEntity.ok(equipos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
	}

	@GetMapping("/recuperarEquipo")
	public ResponseEntity<EquipoDTO> recuperarEquipo(@RequestBody EquipoDTO equipoParam) {
		try {
			EquipoDTO equipo = gestionarEquipoService.recuperarEquipo(equipoParam);
			return ResponseEntity.ok(equipo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
	}

	@GetMapping("/recuperarJugadores")
	public ResponseEntity<List<JugadorDTO>> recuperarJugadores() {
		try {
			List<JugadorDTO> jugadores = gestionarJugadorService.recuperarJugadores();
			return ResponseEntity.ok(jugadores);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);

		}
	}

	@PutMapping("/valorarJugador")
	public ResponseEntity<VotoDTO> votarJugador(@RequestBody VotoDTO voto) {
		try {
			VotoDTO votoActualizado = votoService.annadirVotoJugador(voto);
					
			return ResponseEntity.ok(votoActualizado);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@PostMapping("registrarUsuario")
	public ResponseEntity<Map<String, String>> registrarUsuario(@RequestBody LoginRequestDTO usuario) {
		try {
			Map<String, String> response = new HashMap<>();
			loginService.registrarUsuario(usuario);
			response.put("message", "Registrado correctamente");
			return ResponseEntity.ok(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	
	@GetMapping("/recuperarPartidos/{equipoId}")
	public ResponseEntity<List<Partido>> obtenerPartidosPorEquipo(@PathVariable Long equipoId) {
        List<Partido> partidos = gestionarEquipoService.recuperarPartidosPorEquipo(equipoId);
        if (partidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(partidos);
    }
}
