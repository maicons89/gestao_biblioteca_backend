package br.com.entra21.trabalhofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Exemplar")
public class Exemplar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false)
	private Long codigoExemplar;

	@Column(nullable = true, length = 255, unique = false)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_livro", insertable = false, updatable = false)
	private Livro livro;

	public Exemplar() {
	}

	public Exemplar(Long id, Long codigoExemplar, String descricao, Livro livro) {
		this.id = id;
		this.codigoExemplar = codigoExemplar;
		this.descricao = descricao;
		this.livro = livro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoExemplar() {
		return codigoExemplar;
	}

	public void setCodigoExemplar(Long codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
