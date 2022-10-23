package br.com.entra21.trabalhofinal.entity;

import java.time.LocalDate;

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
@Table(name = "ExemplarEmprestimo")
public class ExemplarEmprestimo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = false)
	private LocalDate dataEmprestimo;

	@Column(nullable = true, unique = false)
	private LocalDate dataDevolucao;

	@Column(nullable = false, unique = false)
	private LocalDate dataDevolucaoPrevista;

	@Column(name = "id_exemplar")
	private Long idExemplar;

	@Column(name = "id_usuario")
	private Long idUsuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_exemplar", insertable = false, updatable = false)
	private Exemplar exemplar;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", insertable = false, updatable = false)
	private Usuario usuario;

	public ExemplarEmprestimo() {
	}

	public ExemplarEmprestimo(Long id, LocalDate dataEmprestimo, LocalDate dataDevolucao,
			LocalDate dataDevolucaoPrevista, Long idExemplar, Long idUsuario) {
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
		this.idExemplar = idExemplar;
		this.idUsuario = idUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public LocalDate getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}

	public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}

	public Long getIdExemplar() {
		return idExemplar;
	}

	public void setIdExemplar(Long idExemplar) {
		this.idExemplar = idExemplar;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
