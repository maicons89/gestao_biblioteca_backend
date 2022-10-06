package br.com.entra21.trabalhofinal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 255, unique = false)
	private String nome;

	@Column(nullable = false, length = 255, unique = true)
	private String cpf;

	@Column(nullable = false, length = 255, unique = false)
	private String telefone;

	@Column(nullable = false, length = 255, unique = false)
	private String email;

	@Column(nullable = false, length = 255, unique = false)
	private String senha;

	@Column(nullable = false)
	private boolean administrador;

	@Column(nullable = false, length = 255, unique = false)
	private String logradouro;

	@Column(nullable = false, unique = false)
	private Long numero;

	@Column(nullable = true, length = 255, unique = false)
	private String complemento;

	@Column(nullable = false, length = 255, unique = false)
	private String cep;

	@Column(nullable = false, length = 255, unique = false)
	private String bairro;

	public Usuario() {
	}

	public Usuario(Long id, String nome, String cpf, String telefone, String email, String senha, boolean administrador,
			String logradouro, Long numero, String complemento, String cep, String bairro) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.administrador = administrador;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;
	}

}
