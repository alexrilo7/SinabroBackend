package com.appSinabro.BdOSinabro.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JugadorDTO {
	private Long id;
	private String nombre;
	private String apellidos;
	private int dorsal;
	private float valoracion;
	private int goles;
	private int asistencias;
	private long equipoId;
}
