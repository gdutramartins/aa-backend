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
@Table(name = "cad_municipio")
public class MunicipioEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "municipio_jpa_sequence_generator")
	@SequenceGenerator(name="municipio_jpa_sequence_generator", sequenceName = "municipio_id_seq", allocationSize = 1)
	private Long id;
	
	@Column(nullable = false)
	private Long codigo;
	
	@Column(nullable = false, length = 100)
	private String nome;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idEstado", nullable = false)
	private EstadoEntity estado;


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

	public EstadoEntity getEstado() {
		return estado;
	}


	public void setEstado(EstadoEntity estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "MunicipioEntity [id=" + id + ", codigo=" + codigo + ", nome=" + nome + ", estado=" + estado + "]";
	}
	
}
