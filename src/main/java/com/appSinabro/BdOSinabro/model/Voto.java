package com.appSinabro.BdOSinabro.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votos")
public class Voto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Usuario que realiza el voto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_id", nullable = false)
	private LoginRequest usuario;

	// Jugador al que se vota
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "jugador_id", nullable = false)
	private Jugador jugador;

	// Partido en el que se realiza el voto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "partido_id", nullable = false)
	private Partido partido;

	// Valoración otorgada en el voto
	@Column(nullable = false)
	private float valoracion;

	// Fecha y hora del voto (opcional)
	@Column(name = "fecha_voto")
	private LocalDateTime fechaVoto;
	
	@Column(name = "goles")
	private int goles;
	
	@Column(name = "asistencias")
	private int asistencias;
}
