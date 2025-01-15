package com.appSinabro.BdOSinabro.mapping;

import com.appSinabro.BdOSinabro.Dto.JugadorDTO;
import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.Dto.PartidoDTO;
import com.appSinabro.BdOSinabro.Dto.VotoDTO;
import com.appSinabro.BdOSinabro.model.Jugador;
import com.appSinabro.BdOSinabro.model.LoginRequest;
import com.appSinabro.BdOSinabro.model.Partido;
import com.appSinabro.BdOSinabro.model.Voto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T16:00:15+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Eclipse Adoptium)"
)
@Component
public class VotoMapperImpl implements VotoMapper {

    @Override
    public VotoDTO votoToVotoDTO(Voto voto) {
        if ( voto == null ) {
            return null;
        }

        VotoDTO votoDTO = new VotoDTO();

        votoDTO.setJugador( jugadorToJugadorDTO( voto.getJugador() ) );
        votoDTO.setPartido( partidoToPartidoDTO( voto.getPartido() ) );
        votoDTO.setUsuario( loginRequestToLoginRequestDTO( voto.getUsuario() ) );
        votoDTO.setGoles( voto.getGoles() );
        votoDTO.setAsistencias( voto.getAsistencias() );
        votoDTO.setValoracion( voto.getValoracion() );

        return votoDTO;
    }

    @Override
    public Voto votoDTOToVoto(VotoDTO jugadorDTO) {
        if ( jugadorDTO == null ) {
            return null;
        }

        Voto voto = new Voto();

        voto.setUsuario( loginRequestDTOToLoginRequest( jugadorDTO.getUsuario() ) );
        voto.setJugador( jugadorDTOToJugador( jugadorDTO.getJugador() ) );
        voto.setPartido( partidoDTOToPartido( jugadorDTO.getPartido() ) );
        voto.setValoracion( jugadorDTO.getValoracion() );
        voto.setGoles( jugadorDTO.getGoles() );
        voto.setAsistencias( jugadorDTO.getAsistencias() );

        return voto;
    }

    protected JugadorDTO jugadorToJugadorDTO(Jugador jugador) {
        if ( jugador == null ) {
            return null;
        }

        JugadorDTO jugadorDTO = new JugadorDTO();

        jugadorDTO.setId( jugador.getId() );
        jugadorDTO.setNombre( jugador.getNombre() );
        jugadorDTO.setApellidos( jugador.getApellidos() );
        jugadorDTO.setDorsal( jugador.getDorsal() );
        jugadorDTO.setValoracion( jugador.getValoracion() );
        jugadorDTO.setGoles( jugador.getGoles() );
        jugadorDTO.setAsistencias( jugador.getAsistencias() );

        return jugadorDTO;
    }

    protected PartidoDTO partidoToPartidoDTO(Partido partido) {
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

    protected LoginRequestDTO loginRequestToLoginRequestDTO(LoginRequest loginRequest) {
        if ( loginRequest == null ) {
            return null;
        }

        LoginRequestDTO loginRequestDTO = new LoginRequestDTO();

        loginRequestDTO.setEmail( loginRequest.getEmail() );
        loginRequestDTO.setPassword( loginRequest.getPassword() );

        return loginRequestDTO;
    }

    protected LoginRequest loginRequestDTOToLoginRequest(LoginRequestDTO loginRequestDTO) {
        if ( loginRequestDTO == null ) {
            return null;
        }

        LoginRequest loginRequest = new LoginRequest();

        loginRequest.setEmail( loginRequestDTO.getEmail() );
        loginRequest.setPassword( loginRequestDTO.getPassword() );

        return loginRequest;
    }

    protected Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO) {
        if ( jugadorDTO == null ) {
            return null;
        }

        Jugador jugador = new Jugador();

        jugador.setId( jugadorDTO.getId() );
        jugador.setNombre( jugadorDTO.getNombre() );
        jugador.setApellidos( jugadorDTO.getApellidos() );
        jugador.setDorsal( jugadorDTO.getDorsal() );
        jugador.setValoracion( jugadorDTO.getValoracion() );
        jugador.setGoles( jugadorDTO.getGoles() );
        jugador.setAsistencias( jugadorDTO.getAsistencias() );

        return jugador;
    }

    protected Partido partidoDTOToPartido(PartidoDTO partidoDTO) {
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
}
