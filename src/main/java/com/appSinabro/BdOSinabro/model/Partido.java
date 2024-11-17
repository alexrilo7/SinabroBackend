package com.appSinabro.BdOSinabro.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "partidos")
@Getter
@Setter
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // El identificador del partido

    @ManyToOne
    @JoinColumn(name = "equipo_local_id", referencedColumnName = "id", nullable = false)
    private Equipo equipoLocal; // Relación con el equipo local

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id", referencedColumnName = "id", nullable = false)
    private Equipo equipoVisitante; // Relación con el equipo visitante

    @Temporal(TemporalType.DATE)
    private Date fecha; // Fecha del partido

    private String tipo; // Tipo de partido: 'ida' o 'vuelta'
}