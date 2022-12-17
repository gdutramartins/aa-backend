package br.com.aaz.security.dto;

public class SignupRequestDTO {
	
	public String username;
	public String password;
	public String nome;
	
	public SignupRequestDTO(String username, String password, String nome) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
	}
	
	

}
