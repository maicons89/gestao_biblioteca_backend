package br.com.entra21.trabalhofinal.entity;

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
@Table(name = "Livro")
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255, unique = true)
	private String isbn;

	@Column(nullable = false, length = 255, unique = false)
	private String tituloPrincipal;

	@Column(nullable = true, length = 255, unique = false)
	private String formasVariantesDoTitulo;

	@Column(nullable = false, unique = false)
	private Long numeroEdicao;

	@Column(nullable = true, length = 1000, unique = false)
	private String descricaoFisica;

	@Column(nullable = true, unique = false)
	private Long qtdDisponivelEmprestimo;

	@Column(nullable = false, length = 255, unique = false)
	private String descricao;

	@Column(nullable = true, length = 255, unique = false)
	private String status;

	@Column(name = "id_assunto")
	private Long idAssunto;

	@Column(name = "id_editora")
	private Long idEditora;

	@Column(name = "id_autor")
	private Long idAutor;

	@Column(name = "id_idioma")
	private Long idIdioma;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_assunto", insertable = false, updatable = false)
	private Assunto assunto;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_editora", insertable = false, updatable = false)
	private Editora editora;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_autor", insertable = false, updatable = false)
	private Autor autor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_idioma", insertable = false, updatable = false)
	private Idioma idioma;

	public Livro() {
	}

	public Livro(Long id, String isbn, String tituloPrincipal, String formasVariantesDoTitulo, Long numeroEdicao,
			String descricaoFisica, Long qtdDisponivelEmprestimo, String descricao, String status, Long idAssunto,
			Long idEditora, Long idAutor, Long idIdioma) {
		this.id = id;
		this.isbn = isbn;
		this.tituloPrincipal = tituloPrincipal;
		this.formasVariantesDoTitulo = formasVariantesDoTitulo;
		this.numeroEdicao = numeroEdicao;
		this.descricaoFisica = descricaoFisica;
		this.qtdDisponivelEmprestimo = qtdDisponivelEmprestimo;
		this.descricao = descricao;
		this.status = status;
		this.idAssunto = idAssunto;
		this.idEditora = idEditora;
		this.idAutor = idAutor;
		this.idIdioma = idIdioma;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTituloPrincipal() {
		return tituloPrincipal;
	}

	public void setTituloPrincipal(String tituloPrincipal) {
		this.tituloPrincipal = tituloPrincipal;
	}

	public String getFormasVariantesDoTitulo() {
		return formasVariantesDoTitulo;
	}

	public void setFormasVariantesDoTitulo(String formasVariantesDoTitulo) {
		this.formasVariantesDoTitulo = formasVariantesDoTitulo;
	}

	public Long getNumeroEdicao() {
		return numeroEdicao;
	}

	public void setNumeroEdicao(Long numeroEdicao) {
		this.numeroEdicao = numeroEdicao;
	}

	public String getDescricaoFisica() {
		return descricaoFisica;
	}

	public void setDescricaoFisica(String descricaoFisica) {
		this.descricaoFisica = descricaoFisica;
	}

	public Long getQtdDisponivelEmprestimo() {
		return qtdDisponivelEmprestimo;
	}

	public void setQtdDisponivelEmprestimo(Long qtdDisponivelEmprestimo) {
		this.qtdDisponivelEmprestimo = qtdDisponivelEmprestimo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Long getIdAssunto() {
		return idAssunto;
	}

	public void setIdAssunto(Long idAssunto) {
		this.idAssunto = idAssunto;
	}

	public Long getIdEditora() {
		return idEditora;
	}

	public void setIdEditora(Long idEditora) {
		this.idEditora = idEditora;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public Long getIdIdioma() {
		return idIdioma;
	}

	public void setIdIdioma(Long idIdioma) {
		this.idIdioma = idIdioma;
	}

}
