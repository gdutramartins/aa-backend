package br.com.aa.security.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "cad_user", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_jpa_sequence_generator")
	@SequenceGenerator(name="user_jpa_sequence_generator", sequenceName = "user_id_seq", allocationSize = 1)
	private Long id;

	private String username;

	private String password;

	private String nome;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "rel_user_role", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_role"))
	private Set<RoleEntity> roles = new HashSet<>();

	public UserEntity() {

	}

	public UserEntity(String username, String nome, String password) {
		this.username = username;
		this.password = password;		
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

}
