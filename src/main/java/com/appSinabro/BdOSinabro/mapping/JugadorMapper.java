package com.appSinabro.BdOSinabro.mapping;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.appSinabro.BdOSinabro.Dto.JugadorDTO;
import com.appSinabro.BdOSinabro.model.Jugador;

@Mapper(componentModel = "spring")
public interface JugadorMapper {

	 // Mapea Jugador a JugadorDTO
	@Mapping(target="equipoId", source="equipo.id")
    JugadorDTO jugadorToJugadorDTO(Jugador jugador);

    // Mapea JugadorDTO a Jugador
	@Mapping(target="equipo.id", source="equipoId")
    Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO);
    
 // Mapea una lista de Jugador a una lista de JugadorDTO
    List<JugadorDTO> jugadoresToJugadorDTOs(List<Jugador> jugadores);

    // Mapea una lista de JugadorDTO a una lista de Jugador
    List<Jugador> jugadorDTOsToJugadores(List<JugadorDTO> jugadorDTOs);
}
