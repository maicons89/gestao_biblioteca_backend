package br.com.entra21.trabalhofinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import br.com.entra21.trabalhofinal.entity.Exemplar;
import br.com.entra21.trabalhofinal.entity.Livro;

public class ExemplarDTO {

	private Long id;

	@NotNull(message = "Campo código exemplar não pode estar vazio.")
	private Long codigoExemplar;

	private String descricao;

	@NotNull(message = "Campo idLivro não pode estar vazio.")
	private Long idLivro;

	private Livro livro;

	public ExemplarDTO() {
	}

	public ExemplarDTO(Exemplar exemplar) {
		this.id = exemplar.getId();
		this.codigoExemplar = exemplar.getCodigoExemplar();
		this.descricao = exemplar.getDescricao();
		this.idLivro = exemplar.getIdLivro();
		this.livro = exemplar.getLivro();
	}

	public Long getId() {
		return id;
	}

	public Long getCodigoExemplar() {
		return codigoExemplar;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public Livro getLivro() {
		return livro;
	}

	public static List<ExemplarDTO> toList(List<Exemplar> Exemplares) {
		return Exemplares.stream().map(ExemplarDTO::new).collect(Collectors.toList());
	}

	public Exemplar toEntity() {
		return new Exemplar(id, codigoExemplar, descricao, idLivro, livro);
	}

}
