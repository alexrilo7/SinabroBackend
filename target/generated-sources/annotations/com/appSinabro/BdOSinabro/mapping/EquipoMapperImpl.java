package com.appSinabro.BdOSinabro.mapping;

import com.appSinabro.BdOSinabro.Dto.EquipoDTO;
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
public class EquipoMapperImpl implements EquipoMapper {

    @Override
    public EquipoDTO equipoToEquipoDTO(Equipo equipo) {
        if ( equipo == null ) {
            return null;
        }

        EquipoDTO equipoDTO = new EquipoDTO();

        equipoDTO.setId( equipo.getId() );
        equipoDTO.setNombre( equipo.getNombre() );
        List<Jugador> list = equipo.getJugadores();
        if ( list != null ) {
            equipoDTO.setJugadores( new ArrayList<Jugador>( list ) );
        }

        return equipoDTO;
    }

    @Override
    public Equipo equipoDTOToEquipo(EquipoDTO equipoDTO) {
        if ( equipoDTO == null ) {
            return null;
        }

        Equipo equipo = new Equipo();

        equipo.setId( equipoDTO.getId() );
        equipo.setNombre( equipoDTO.getNombre() );
        List<Jugador> list = equipoDTO.getJugadores();
        if ( list != null ) {
            equipo.setJugadores( new ArrayList<Jugador>( list ) );
        }

        return equipo;
    }

    @Override
    public List<EquipoDTO> equiposToEquipoDTOs(List<Equipo> equipos) {
        if ( equipos == null ) {
            return null;
        }

        List<EquipoDTO> list = new ArrayList<EquipoDTO>( equipos.size() );
        for ( Equipo equipo : equipos ) {
            list.add( equipoToEquipoDTO( equipo ) );
        }

        return list;
    }

    @Override
    public List<Equipo> equipoDTOsToEquipos(List<EquipoDTO> equipoDTOs) {
        if ( equipoDTOs == null ) {
            return null;
        }

        List<Equipo> list = new ArrayList<Equipo>( equipoDTOs.size() );
        for ( EquipoDTO equipoDTO : equipoDTOs ) {
            list.add( equipoDTOToEquipo( equipoDTO ) );
        }

        return list;
    }
}
