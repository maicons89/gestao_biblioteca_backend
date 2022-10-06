package br.com.entra21.trabalhofinal.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255, unique = false)
	private String nome;

	@Column(nullable = false, unique = false)
	private LocalDate dataNascimento;

	@Column(nullable = true, unique = false)
	private LocalDate dataFalecimento;

	@Column(nullable = false, length = 255, unique = false)
	private String codigoCutter;

	public Autor() {
	}

	public Autor(Long id, String nome, LocalDate dataNascimento, LocalDate dataFalecimento, String codigoCutter) {
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataFalecimento = dataFalecimento;
		this.codigoCutter = codigoCutter;
	}

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public LocalDate getDataFalecimento() {
		return dataFalecimento;
	}

	public void setDataFalecimento(LocalDate dataFalecimento) {
		this.dataFalecimento = dataFalecimento;
	}

	public String getCodigoCutter() {
		return codigoCutter;
	}

	public void setCodigoCutter(String codigoCutter) {
		this.codigoCutter = codigoCutter;
	}

}
