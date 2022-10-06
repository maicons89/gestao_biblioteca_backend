package br.com.entra21.trabalhofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Assunto")
public class Assunto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255)
	private String cdd;

	@Column(nullable = false, length = 255)
	private String nome;

	public Assunto() {
	}

	public Assunto(Long id, String cdd, String nome) {
		this.id = id;
		this.cdd = cdd;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCdd() {
		return cdd;
	}

	public void setCdd(String cdd) {
		this.cdd = cdd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
