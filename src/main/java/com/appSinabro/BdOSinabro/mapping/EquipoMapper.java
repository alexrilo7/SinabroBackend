package com.appSinabro.BdOSinabro.mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.appSinabro.BdOSinabro.Dto.EquipoDTO;
import com.appSinabro.BdOSinabro.model.Equipo;


@Mapper(componentModel = "spring")
public interface EquipoMapper {

	 // Mapea Equipo a EquipoDTO
   EquipoDTO equipoToEquipoDTO(Equipo equipo);

   // Mapea EquipoDTO a Equipo
   Equipo equipoDTOToEquipo(EquipoDTO equipoDTO);

   // Mapea una lista de Equipo a una lista de EquipoDTO
   List<EquipoDTO> equiposToEquipoDTOs(List<Equipo> equipos);

   // Mapea una lista de EquipoDTO a una lista de Equipo
   List<Equipo> equipoDTOsToEquipos(List<EquipoDTO> equipoDTOs);
}
