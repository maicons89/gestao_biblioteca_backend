package br.com.entra21.trabalhofinal.dto;

public class ErroDTO {

	private String mensagem;

	public ErroDTO(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
