package com.appSinabro.BdOSinabro.services;

import java.io.IOException;
import java.sql.SQLException;

import com.appSinabro.BdOSinabro.Dto.VotoDTO;

public interface VotoService {
	public VotoDTO annadirVotoJugador(VotoDTO voto) throws SQLException, IOException;
}
