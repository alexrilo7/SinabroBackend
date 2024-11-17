package com.appSinabro.BdOSinabro.services;

import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;

public interface LoginService {
	public boolean login(LoginRequestDTO loginReq);
	public void registrarUsuario(LoginRequestDTO usuario);
}
