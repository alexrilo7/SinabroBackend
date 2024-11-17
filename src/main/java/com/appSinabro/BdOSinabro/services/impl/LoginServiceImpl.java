package com.appSinabro.BdOSinabro.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appSinabro.BdOSinabro.Dto.LoginRequestDTO;
import com.appSinabro.BdOSinabro.mapping.LoginRequestMapper;
import com.appSinabro.BdOSinabro.services.BDDService;
import com.appSinabro.BdOSinabro.services.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	BDDService bdd;
	
	@Autowired
	LoginRequestMapper mapperLogin;

	@Override
	public boolean login(LoginRequestDTO loginReq) {
		return bdd.existeUsuarioYPassword(loginReq);
	}

	@Override
	public void registrarUsuario(LoginRequestDTO usuario) {
		bdd.registrarUsuario(mapperLogin.loginRequestDTOToLoginRequest(usuario));
	}

}
