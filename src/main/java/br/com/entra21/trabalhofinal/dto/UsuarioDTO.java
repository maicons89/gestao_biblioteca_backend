package br.com.entra21.trabalhofinal.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.entra21.trabalhofinal.entity.Usuario;

public class UsuarioDTO {

	private Long id;

	@NotBlank(message = "Campo nome não pode estar vazio.")
	private String nome;

	@NotBlank(message = "Campo CPF não pode estar vazio.")
	private String cpf;

	@NotBlank(message = "Campo telefone não pode estar vazio.")
	private String telefone;

	@Email(message = "Email inválido.")
	@NotBlank(message = "Campo email não pode estar vazio.")
	private String email;

	private String senha;

	private boolean administrador;

	@NotBlank(message = "Campo logradouro não pode estar vazio.")
	private String logradouro;

	@NotNull(message = "Campo numero não pode estar vazio.")
	private Long numero;

	private String complemento;

	@NotBlank(message = "Campo cep não pode estar vazio.")
	private String cep;

	@NotBlank(message = "Campo bairro não pode estar vazio.")
	private String bairro;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.telefone = usuario.getTelefone();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
		this.administrador = usuario.isAdministrador();
		this.logradouro = usuario.getLogradouro();
		this.numero = usuario.getNumero();
		this.complemento = usuario.getComplemento();
		this.cep = usuario.getCep();
		this.bairro = usuario.getBairro();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAdministrador() {
		return administrador;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public Long getNumero() {
		return numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCep() {
		return cep;
	}

	public String getBairro() {
		return bairro;
	}

	public static List<UsuarioDTO> toList(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

	public Usuario toEntity() {
		return new Usuario(id, nome, cpf, telefone, email, senha, administrador, logradouro, numero, complemento, cep,
				bairro);
	}
}
