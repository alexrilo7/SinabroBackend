package com.appSinabro.BdOSinabro.Dto;

import java.util.Date;

import com.appSinabro.BdOSinabro.model.Equipo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PartidoDTO {

	private Long id; // El identificador del partido
	private Equipo equipoLocal; // Relación con el equipo local
	private Equipo equipoVisitante; // Relación con el equipo visitante
	private Date fecha; // Fecha del partido
	private String tipo; // Tipo de partido: 'ida' o 'vuelta'
}
