package br.com.aaz.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "cad_bairro")
public class BairroEntity {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "bairro_jpa_sequence_generator")
	@SequenceGenerator(name="bairro_jpa_sequence_generator", sequenceName = "bairro_id_seq", allocationSize = 1)
	
	private Long id;
	
	@Column(nullable = false)
	private String codigo;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMunicipio", nullable = false)
	private MunicipioEntity municipio;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public MunicipioEntity getMunicipio() {
		return municipio;
	}

	public void setEstado(MunicipioEntity municipio) {
		this.municipio= municipio;
	}

	@Override
	public String toString() {
		return "BairroEntity [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", municipio=" + municipio + "]";
	}
	
}
