package br.com.entra21.trabalhofinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.entra21.trabalhofinal.entity.Editora;

public class EditoraDTO {

	private Long id;

	@NotBlank(message = "Campo nome não pode estar vazio.")
	private String nome;

	public EditoraDTO() {
	}

	public EditoraDTO(Editora editora) {
		this.id = editora.getId();
		this.nome = editora.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public static List<EditoraDTO> toList(List<Editora> editoras) {
		return editoras.stream().map(EditoraDTO::new).collect(Collectors.toList());
	}

	public Editora toEntity() {
		return new Editora(id, nome);
	}

}
