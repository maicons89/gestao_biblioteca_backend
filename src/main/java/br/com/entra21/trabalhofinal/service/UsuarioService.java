package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.UsuarioDTO;
import br.com.entra21.trabalhofinal.entity.Usuario;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public UsuarioDTO cadastrar(UsuarioDTO usuarioDTO) {
		Usuario usuarioParaSalvar = usuarioDTO.toEntity();
		Usuario usuarioCadastrado = usuarioRepository.save(usuarioParaSalvar);
		usuarioRepository.save(usuarioCadastrado);
		return new UsuarioDTO(usuarioParaSalvar);
	}

	public List<UsuarioDTO> lista() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		return UsuarioDTO.toList(usuarios);
	}

	public UsuarioDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			return new UsuarioDTO(usuario.get());
		}

		throw new NotFoundException("Usuario não encontrada para o id " + id);
	}

	public void excluir(Long id) throws NotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		if (usuario.isPresent()) {
			usuarioRepository.deleteById(id);
		} else {
			throw new NotFoundException("Usuário não encontrada para o id " + id);
		}
	}

	public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioDTO) {
		Usuario usuarioParaAtualizar = usuarioRepository.findById(id).get();
		usuarioParaAtualizar.setNome(usuarioDTO.getNome());
		usuarioParaAtualizar.setCpf(usuarioDTO.getCpf());
		usuarioParaAtualizar.setTelefone(usuarioDTO.getTelefone());
		usuarioParaAtualizar.setEmail(usuarioDTO.getEmail());
		usuarioParaAtualizar.setSenha(usuarioDTO.getSenha());
		usuarioParaAtualizar.setAdministrador(usuarioDTO.isAdministrador());
		usuarioParaAtualizar.setLogradouro(usuarioDTO.getLogradouro());
		usuarioParaAtualizar.setNumero(usuarioDTO.getNumero());
		usuarioParaAtualizar.setComplemento(usuarioDTO.getComplemento());
		usuarioParaAtualizar.setCep(usuarioDTO.getCep());
		usuarioParaAtualizar.setBairro(usuarioDTO.getBairro());
		Usuario usuarioAlterado = usuarioRepository.save(usuarioParaAtualizar);
		return new UsuarioDTO(usuarioAlterado);
	}

}
