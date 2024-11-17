package com.appSinabro.BdOSinabro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="loginrequest")
public class LoginRequest {
	
	@Id
	private String email;
	
	private String password;
}
