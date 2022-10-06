package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.EditoraDTO;
import br.com.entra21.trabalhofinal.entity.Editora;
import br.com.entra21.trabalhofinal.entity.Livro;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.EditoraRepository;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class EditoraService {

	@Autowired
	private EditoraRepository editoraRepository;

	@Autowired
	private LivroRepository livroRepository;

	public List<EditoraDTO> lista() {
		List<Editora> editoras = editoraRepository.findAll();
		return EditoraDTO.toList(editoras);
	}

	public EditoraDTO cadastrar(EditoraDTO editoraDTO) {
		Editora editoraParaSalvar = editoraDTO.toEntity();
		Editora editoraCadastrada = editoraRepository.save(editoraParaSalvar);
		return new EditoraDTO(editoraCadastrada);
	}

	public EditoraDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Editora> editora = editoraRepository.findById(id);
		if (editora.isPresent()) {
			return new EditoraDTO(editora.get());
		}

		throw new NotFoundException("Editora não encontrada para o id " + id);
	}

	public void excluir(Long id) throws NotFoundException, EntidadeEmUsoException {

		List<Livro> livros = livroRepository.findByIdEditora(id);
		if (!livros.isEmpty()) {
			throw new EntidadeEmUsoException("Editora com id " + id + " está em uso. Não é possível excluir");
		}

		Optional<Editora> editora = editoraRepository.findById(id);
		if (editora.isPresent()) {
			editoraRepository.deleteById(id);
		} else {
			throw new NotFoundException("Editora não encontrada para o id " + id);
		}
	}

	public EditoraDTO atualizar(Long id, EditoraDTO editoraDTO) {
		Editora editoraParaAtualizar = editoraRepository.findById(id).get();
		editoraParaAtualizar.setNome(editoraDTO.getNome());
		Editora editoraAlterada = editoraRepository.save(editoraParaAtualizar);
		return new EditoraDTO(editoraAlterada);
	}

}
