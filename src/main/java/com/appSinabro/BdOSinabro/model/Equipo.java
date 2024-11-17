package com.appSinabro.BdOSinabro.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="equipo")
public class Equipo {
	
	@Id
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "equipo")
	@JsonIgnore
    private List<Jugador> jugadores; // Relación inversa con Jugador
}


