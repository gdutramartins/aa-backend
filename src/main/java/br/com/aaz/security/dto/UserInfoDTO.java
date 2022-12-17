package br.com.aaz.security.dto;

import java.util.List;

public class UserInfoDTO {
	public Long id;
	public String username;
	public String nome;
	public List<String> roles;
	
	public UserInfoDTO(Long id, String username, String nome, List<String> roles) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.roles = roles;
	}
	
	
}
