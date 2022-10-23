package br.com.entra21.trabalhofinal.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import br.com.entra21.trabalhofinal.entity.Exemplar;
import br.com.entra21.trabalhofinal.entity.ExemplarEmprestimo;
import br.com.entra21.trabalhofinal.entity.Usuario;

public class ExemplarEmprestimoDTO {

	private Long id;

	@JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataEmprestimo;

	@JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataDevolucao;

	@JsonFormat(pattern = "yyyy/MM/dd", shape = JsonFormat.Shape.STRING)
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	private LocalDate dataDevolucaoPrevista;

	@NotNull(message = "Campo idExemplar não pode estar vazio.")
	private Long idExemplar;

	@NotNull(message = "Campo idUsuario não pode estar vazio.")
	private Long idUsuario;

	private Exemplar exemplar;

	private Usuario usuario;

	public ExemplarEmprestimoDTO() {
	}

	public ExemplarEmprestimoDTO(ExemplarEmprestimo exemplarEmprestimo) {
		this.id = exemplarEmprestimo.getId();
		this.dataEmprestimo = exemplarEmprestimo.getDataEmprestimo();
		this.dataDevolucaoPrevista = exemplarEmprestimo.getDataDevolucaoPrevista();
		this.dataDevolucao = exemplarEmprestimo.getDataDevolucao();
		this.idExemplar = exemplarEmprestimo.getIdExemplar();
		this.idUsuario = exemplarEmprestimo.getIdUsuario();
		this.exemplar = exemplarEmprestimo.getExemplar();
		this.usuario = exemplarEmprestimo.getUsuario();

	}

	public Long getId() {
		return id;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDeveolucao() {
		return dataDevolucao;
	}

	public LocalDate getDataDeveolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public Long getIdExemplar() {
		return idExemplar;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public static List<ExemplarEmprestimoDTO> toList(List<ExemplarEmprestimo> exemplaresEmprestimos) {
		return exemplaresEmprestimos.stream().map(ExemplarEmprestimoDTO::new).collect(Collectors.toList());
	}

	public ExemplarEmprestimo toEntity() {
		return new ExemplarEmprestimo(id, dataEmprestimo, dataDevolucao, dataDevolucaoPrevista, idExemplar, idUsuario);
	}

}
