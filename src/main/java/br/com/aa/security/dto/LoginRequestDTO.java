package br.com.aa.security.dto;

public class LoginRequestDTO {
	public String username;
	public String password;
	
	public LoginRequestDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

}
