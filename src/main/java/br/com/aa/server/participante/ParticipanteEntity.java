package br.com.aa.server.participante;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.aa.domain.BairroEntity;
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
@Table(name = "cad_participante")
public class ParticipanteEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "participante_jpa_sequence_generator")
	@SequenceGenerator(name="participante_jpa_sequence_generator", sequenceName = "participante_id_seq", allocationSize = 1)
	private Long id;	
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idBairro")
	private BairroEntity bairro;
	
	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	@Column(nullable = false)
	private LocalDateTime dataCriacao;
	
	@Column(nullable = false)
	private LocalDateTime dataAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BairroEntity getBairro() {
		return bairro;
	}

	public void setBairro(BairroEntity bairro) {
		this.bairro = bairro;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
}
