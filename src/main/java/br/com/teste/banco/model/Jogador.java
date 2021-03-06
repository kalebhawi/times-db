package br.com.teste.banco.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Jogador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Long idTime;
	private String nome;
	private LocalDate dataNascimento;
	private Integer nivelHabilidade;
	private BigDecimal salario;
	private Time time;

	public Jogador() {
		
	}

	public Jogador(String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario, Time time) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.nivelHabilidade = nivelHabilidade;
		this.salario = salario;
		this.time = time;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "id_time")
	public Long getIdTime() {
		return idTime;
	}

	
	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	@Column
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "data_nascimento")
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Column(name = "nivel_habilidade")
	public Integer getNivelHabilidade() {
		return nivelHabilidade;
	}

	public void setNivelHabilidade(Integer nivelHabilidade) {
		this.nivelHabilidade = nivelHabilidade;
	}

	@Column
	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "time_id")
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Jogador [id=" + id + ", idTime=" + idTime + ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", nivelHabilidade=" + nivelHabilidade + ", salario=" + salario + ", time=" + time.getNome() + "]";
	}

}
