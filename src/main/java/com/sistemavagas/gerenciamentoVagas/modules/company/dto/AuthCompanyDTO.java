package com.sistemavagas.gerenciamentoVagas.modules.company.dto;

public class AuthCompanyDTO {
	private String password;
	private String username;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AuthCompanyDTO(String password, String username) {
		this.password = password;
		this.username = username;
	}
		
}
