package com.appSinabro.BdOSinabro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@Column(name="dorsal")
	private int dorsal;
	
	@Column(name="valoracion")
	private float valoracion;
	
	@Column(name="goles")
	private int goles;
	
	@Column(name="asistencias")
	private int asistencias;
	
	@ManyToOne
    @JoinColumn(name = "equipo_id", nullable = false)
	@JsonBackReference
    private Equipo equipo; // Relación con Equipo
}
