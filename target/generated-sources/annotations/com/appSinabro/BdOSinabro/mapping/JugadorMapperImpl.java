package com.appSinabro.BdOSinabro.mapping;

import com.appSinabro.BdOSinabro.Dto.JugadorDTO;
import com.appSinabro.BdOSinabro.model.Equipo;
import com.appSinabro.BdOSinabro.model.Jugador;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T16:00:14+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class JugadorMapperImpl implements JugadorMapper {

    @Override
    public JugadorDTO jugadorToJugadorDTO(Jugador jugador) {
        if ( jugador == null ) {
            return null;
        }

        JugadorDTO jugadorDTO = new JugadorDTO();

        Long id = jugadorEquipoId( jugador );
        if ( id != null ) {
            jugadorDTO.setEquipoId( id );
        }
        jugadorDTO.setId( jugador.getId() );
        jugadorDTO.setNombre( jugador.getNombre() );
        jugadorDTO.setApellidos( jugador.getApellidos() );
        jugadorDTO.setDorsal( jugador.getDorsal() );
        jugadorDTO.setValoracion( jugador.getValoracion() );
        jugadorDTO.setGoles( jugador.getGoles() );
        jugadorDTO.setAsistencias( jugador.getAsistencias() );

        return jugadorDTO;
    }

    @Override
    public Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO) {
        if ( jugadorDTO == null ) {
            return null;
        }

        Jugador jugador = new Jugador();

        jugador.setEquipo( jugadorDTOToEquipo( jugadorDTO ) );
        jugador.setId( jugadorDTO.getId() );
        jugador.setNombre( jugadorDTO.getNombre() );
        jugador.setApellidos( jugadorDTO.getApellidos() );
        jugador.setDorsal( jugadorDTO.getDorsal() );
        jugador.setValoracion( jugadorDTO.getValoracion() );
        jugador.setGoles( jugadorDTO.getGoles() );
        jugador.setAsistencias( jugadorDTO.getAsistencias() );

        return jugador;
    }

    @Override
    public List<JugadorDTO> jugadoresToJugadorDTOs(List<Jugador> jugadores) {
        if ( jugadores == null ) {
            return null;
        }

        List<JugadorDTO> list = new ArrayList<JugadorDTO>( jugadores.size() );
        for ( Jugador jugador : jugadores ) {
            list.add( jugadorToJugadorDTO( jugador ) );
        }

        return list;
    }

    @Override
    public List<Jugador> jugadorDTOsToJugadores(List<JugadorDTO> jugadorDTOs) {
        if ( jugadorDTOs == null ) {
            return null;
        }

        List<Jugador> list = new ArrayList<Jugador>( jugadorDTOs.size() );
        for ( JugadorDTO jugadorDTO : jugadorDTOs ) {
            list.add( jugadorDTOToJugador( jugadorDTO ) );
        }

        return list;
    }

    private Long jugadorEquipoId(Jugador jugador) {
        if ( jugador == null ) {
            return null;
        }
        Equipo equipo = jugador.getEquipo();
        if ( equipo == null ) {
            return null;
        }
        Long id = equipo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Equipo jugadorDTOToEquipo(JugadorDTO jugadorDTO) {
        if ( jugadorDTO == null ) {
            return null;
        }

        Equipo equipo = new Equipo();

        equipo.setId( jugadorDTO.getEquipoId() );

        return equipo;
    }
}
