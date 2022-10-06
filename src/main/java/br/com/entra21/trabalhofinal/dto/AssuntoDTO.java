package br.com.entra21.trabalhofinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.entra21.trabalhofinal.entity.Assunto;

public class AssuntoDTO {

	private Long id;

	@NotBlank(message = "Campo nome não pode estar vazio.")
	private String nome;

	@NotBlank(message = "Campo cdd não pode estar vazio.")
	private String cdd;

	public AssuntoDTO() {
	}

	public AssuntoDTO(Assunto assunto) {
		this.id = assunto.getId();
		this.nome = assunto.getNome();
		this.cdd = assunto.getCdd();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCdd() {
		return cdd;
	}

	public static List<AssuntoDTO> toList(List<Assunto> assuntos) {
		return assuntos.stream().map(AssuntoDTO::new).collect(Collectors.toList());
	}

	public Assunto toEntity() {
		return new Assunto(id, nome, cdd);
	}

}
