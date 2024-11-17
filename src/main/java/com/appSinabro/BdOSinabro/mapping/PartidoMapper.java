package com.appSinabro.BdOSinabro.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.appSinabro.BdOSinabro.Dto.PartidoDTO;
import com.appSinabro.BdOSinabro.model.Partido;


@Mapper(componentModel = "spring")
public interface PartidoMapper {

	 // Mapea partido a partidoDTO
   PartidoDTO partidoTopartidoDTO(Partido partido);

   // Mapea partidoDTO a partido
   Partido partidoDTOToPartido(PartidoDTO partidoDTO);

   // Mapea una lista de partido a una lista de partidoDTO
   List<PartidoDTO> partidosTopartidoDTOs(List<Partido> partidos);

   // Mapea una lista de partidoDTO a una lista de partido
   List<Partido> partidoDTOsTopartidos(List<PartidoDTO> partidoDTOs);
}
