package com.appSinabro.BdOSinabro.Dto;

import java.util.List;

import com.appSinabro.BdOSinabro.model.Jugador;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EquipoDTO {
	private Long id;
	private String nombre;
	private List<Jugador> jugadores;
}
