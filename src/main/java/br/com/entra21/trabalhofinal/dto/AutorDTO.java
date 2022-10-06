package br.com.entra21.trabalhofinal.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.entra21.trabalhofinal.entity.Autor;

public class AutorDTO {

	private Long id;

	@NotBlank(message = "Campo nome não pode estar vazio.")
	private String nome;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataNascimento;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataFalecimento;

	@NotBlank(message = "Campo código cutter não pode estar vazio.")
	private String codigoCutter;

	public AutorDTO() {
	}

	public AutorDTO(Autor autor) {
		this.id = autor.getId();
		this.nome = autor.getNome();
		this.dataNascimento = autor.getDataNascimento();
		this.dataFalecimento = autor.getDataFalecimento();
		this.codigoCutter = autor.getCodigoCutter();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public LocalDate getDataFalecimento() {
		return dataFalecimento;
	}

	public String getCodigoCutter() {
		return codigoCutter;
	}

	public static List<AutorDTO> toList(List<Autor> nome) {
		return nome.stream().map(AutorDTO::new).collect(Collectors.toList());
	}

	public Autor toEntity() {
		return new Autor(id, nome, dataNascimento, dataFalecimento, codigoCutter);
	}

}
