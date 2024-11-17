package com.appSinabro.BdOSinabro.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VotoDTO {
	private JugadorDTO jugador;
	private PartidoDTO partido;
	private LoginRequestDTO usuario;
	private int goles;
	private int asistencias;
	private float valoracion;
}
