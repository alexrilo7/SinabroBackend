package com.appSinabro.BdOSinabro.mapping;

import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.model.LoginRequest;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T16:00:14+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class LoginRequestMapperImpl implements LoginRequestMapper {

    @Override
    public LoginRequestDTO loginRequestToLoginRequestDTO(LoginRequest login) {
        if ( login == null ) {
            return null;
        }

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();

        loginRequestDTO.setEmail( login.getEmail() );
        loginRequestDTO.setPassword( login.getPassword() );

        return loginRequestDTO;
    }

    @Override
    public LoginRequest loginRequestDTOToLoginRequest(LoginRequestDTO loginRequestDTO) {
        if ( loginRequestDTO == null ) {
            return null;
        }

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail( loginRequestDTO.getEmail() );
        loginRequest.setPassword( loginRequestDTO.getPassword() );

        return loginRequest;
    }
}
