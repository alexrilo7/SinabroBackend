package com.appSinabro.BdOSinabro.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.appSinabro.BdOSinabro.Dto.VotoDTO;
import com.appSinabro.BdOSinabro.model.Voto;

@Mapper(componentModel = "spring")
public interface VotoMapper {
	// Mapea Voto a VotoDTO
	VotoDTO votoToVotoDTO(Voto voto);

	// Mapea VotoDTO a Voto
	@Mapping(target = "fechaVoto", ignore = true)
	@Mapping(target = "id", ignore = true)
	Voto votoDTOToVoto(VotoDTO jugadorDTO);
}
