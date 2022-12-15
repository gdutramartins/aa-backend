package br.com.aa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "cad_estado")
public class EstadoEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "estado_jpa_sequence_generator")
	@SequenceGenerator(name="estado_jpa_sequence_generator", sequenceName = "estado_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private Long codigo;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	
	@Column(nullable = false, length = 2)
	private String sigla;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSigla() {
		return sigla;
	}


	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	@Override
	public String toString() {
		return "EstadoEntity [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", sigla=" + sigla + "]";
	}
	
}
