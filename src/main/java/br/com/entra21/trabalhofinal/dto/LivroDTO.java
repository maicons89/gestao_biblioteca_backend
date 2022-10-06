package br.com.entra21.trabalhofinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.entra21.trabalhofinal.entity.Assunto;
import br.com.entra21.trabalhofinal.entity.Autor;
import br.com.entra21.trabalhofinal.entity.Editora;
import br.com.entra21.trabalhofinal.entity.Idioma;
import br.com.entra21.trabalhofinal.entity.Livro;

public class LivroDTO {

	private Long id;

	@NotBlank(message = "Campo ISBN não pode estar vazio.")
	private String isbn;

	@NotBlank(message = "Campo Título Principal não pode estar vazio.")
	private String tituloPrincipal;

	private String formasVariantesDoTitulo;

	@NotNull(message = "Campo Número Edição Principal não pode estar vazio.")
	private Long numeroEdicao;

	private String descricaoFisica;

	@NotNull(message = "Campo Quantidade Dsponível Empréstimo não pode estar vazio.")
	private Long qtdDisponivelEmprestimo;

	@NotBlank(message = "Campo Descrição não pode estar vazio.")
	private String descricao;

	@NotBlank(message = "Campo Status não pode estar vazio.")
	private String status;

	@NotNull(message = "Campo idAssunto não pode estar vazio.")
	private Long idAssunto;

	@NotNull(message = "Campo idEditora não pode estar vazio.")
	private Long idEditora;

	@NotNull(message = "Campo idAutor não pode estar vazio.")
	private Long idAutor;

	@NotNull(message = "Campo idIdioma não pode estar vazio.")
	private Long idIdioma;

	private Assunto assunto;

	private Editora editora;

	private Autor autor;

	private Idioma idioma;

	public LivroDTO() {
	}

	public LivroDTO(Livro livro) {
		this.id = livro.getId();
		this.isbn = livro.getIsbn();
		this.tituloPrincipal = livro.getTituloPrincipal();
		this.formasVariantesDoTitulo = livro.getFormasVariantesDoTitulo();
		this.numeroEdicao = livro.getNumeroEdicao();
		this.descricaoFisica = livro.getDescricaoFisica();
		this.qtdDisponivelEmprestimo = livro.getQtdDisponivelEmprestimo();
		this.descricao = livro.getDescricao();
		this.status = livro.getStatus();
		this.idAssunto = livro.getIdAssunto();
		this.idEditora = livro.getIdEditora();
		this.idAutor = livro.getIdAutor();
		this.idIdioma = livro.getIdIdioma();
		this.assunto = livro.getAssunto();
		this.editora = livro.getEditora();
		this.autor = livro.getAutor();
		this.idioma = livro.getIdioma();
	}

	public Long getId() {
		return id;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTituloPrincipal() {
		return tituloPrincipal;
	}

	public String getFormasVariantesDoTitulo() {
		return formasVariantesDoTitulo;
	}

	public Long getNumeroEdicao() {
		return numeroEdicao;
	}

	public String getDescricaoFisica() {
		return descricaoFisica;
	}

	public Long getQtdDisponivelEmprestimo() {
		return qtdDisponivelEmprestimo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getStatus() {
		return status;
	}

	public Long getIdAssunto() {
		return idAssunto;
	}

	public Long getIdEditora() {
		return idEditora;
	}

	public Long getIdAutor() {
		return idAutor;
	}

	public Long getIdIdioma() {
		return idIdioma;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public Editora getEditora() {
		return editora;
	}

	public Autor getAutor() {
		return autor;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public static List<LivroDTO> toList(List<Livro> livros) {
		return livros.stream().map(LivroDTO::new).collect(Collectors.toList());
	}

	public Livro toEntity() {
		return new Livro(id, isbn, tituloPrincipal, formasVariantesDoTitulo, numeroEdicao, descricaoFisica,
				qtdDisponivelEmprestimo, descricao, status, idAssunto, idEditora, idAutor, idIdioma);
	}

}
