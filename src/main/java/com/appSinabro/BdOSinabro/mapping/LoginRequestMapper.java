package com.appSinabro.BdOSinabro.mapping;

import org.mapstruct.Mapper;

import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.model.LoginRequest;

@Mapper(componentModel = "spring")
public interface LoginRequestMapper {
	 // Mapea LoginRequest a LoginRequestDTO
    LoginRequestDTO loginRequestToLoginRequestDTO(LoginRequest login);

    // Mapea LoginRequestDTO a LoginRequest
    LoginRequest loginRequestDTOToLoginRequest(LoginRequestDTO loginRequestDTO);
}
