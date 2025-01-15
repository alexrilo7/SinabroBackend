package com.appSinabro.BdOSinabro.mapping;

import com.appSinabro.BdOSinabro.Dto.PartidoDTO;
import com.appSinabro.BdOSinabro.model.Partido;
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
public class PartidoMapperImpl implements PartidoMapper {

    @Override
    public PartidoDTO partidoTopartidoDTO(Partido partido) {
        if ( partido == null ) {
            return null;
        }

        PartidoDTO partidoDTO = new PartidoDTO();

        partidoDTO.setId( partido.getId() );
        partidoDTO.setEquipoLocal( partido.getEquipoLocal() );
        partidoDTO.setEquipoVisitante( partido.getEquipoVisitante() );
        partidoDTO.setFecha( partido.getFecha() );
        partidoDTO.setTipo( partido.getTipo() );

        return partidoDTO;
    }

    @Override
    public Partido partidoDTOToPartido(PartidoDTO partidoDTO) {
        if ( partidoDTO == null ) {
            return null;
        }

        Partido partido = new Partido();

        partido.setId( partidoDTO.getId() );
        partido.setEquipoLocal( partidoDTO.getEquipoLocal() );
        partido.setEquipoVisitante( partidoDTO.getEquipoVisitante() );
        partido.setFecha( partidoDTO.getFecha() );
        partido.setTipo( partidoDTO.getTipo() );

        return partido;
    }

    @Override
    public List<PartidoDTO> partidosTopartidoDTOs(List<Partido> partidos) {
        if ( partidos == null ) {
            return null;
        }

        List<PartidoDTO> list = new ArrayList<PartidoDTO>( partidos.size() );
        for ( Partido partido : partidos ) {
            list.add( partidoTopartidoDTO( partido ) );
        }

        return list;
    }

    @Override
    public List<Partido> partidoDTOsTopartidos(List<PartidoDTO> partidoDTOs) {
        if ( partidoDTOs == null ) {
            return null;
        }

        List<Partido> list = new ArrayList<Partido>( partidoDTOs.size() );
        for ( PartidoDTO partidoDTO : partidoDTOs ) {
            list.add( partidoDTOToPartido( partidoDTO ) );
        }

        return list;
    }
}
