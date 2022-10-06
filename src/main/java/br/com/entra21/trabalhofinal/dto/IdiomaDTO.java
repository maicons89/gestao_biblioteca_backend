package br.com.entra21.trabalhofinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.entra21.trabalhofinal.entity.Idioma;

public class IdiomaDTO {

	private Long id;

	@NotBlank(message = "Campo idioma não pode estar vazio.")
	private String idioma;

	@NotBlank(message = "Campo sigla não pode estar vazio.")
	private String sigla;

	public IdiomaDTO() {
	}

	public IdiomaDTO(Idioma idioma) {
		this.id = idioma.getId();
		this.idioma = idioma.getIdioma();
		this.sigla = idioma.getSigla();
	}

	public Long getId() {
		return id;
	}

	public String getIdioma() {
		return idioma;
	}

	public String getSigla() {
		return sigla;
	}

	public static List<IdiomaDTO> toList(List<Idioma> idiomas) {
		return idiomas.stream().map(IdiomaDTO::new).collect(Collectors.toList());
	}

	public Idioma toEntity() {
		return new Idioma(id, idioma, sigla);
	}
}
