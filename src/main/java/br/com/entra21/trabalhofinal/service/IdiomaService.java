package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.IdiomaDTO;
import br.com.entra21.trabalhofinal.entity.Idioma;
import br.com.entra21.trabalhofinal.entity.Livro;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.IdiomaRepository;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class IdiomaService {

	@Autowired
	private IdiomaRepository idiomaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public List<IdiomaDTO> lista() {
		List<Idioma> idiomas = idiomaRepository.findAll();
		return IdiomaDTO.toList(idiomas);
	}

	public IdiomaDTO cadastrar(IdiomaDTO idiomaDTO) {
		Idioma idiomaParaSalvar = idiomaDTO.toEntity();
		Idioma idiomaCadastrado = idiomaRepository.save(idiomaParaSalvar);
		return new IdiomaDTO(idiomaCadastrado);
	}

	public IdiomaDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Idioma> idioma = idiomaRepository.findById(id);
		if (idioma.isPresent()) {
			return new IdiomaDTO(idioma.get());
		}

		throw new NotFoundException("Idioma não encontrado para o id " + id);
	}

	public void excluir(Long id) throws NotFoundException, EntidadeEmUsoException {

		List<Livro> livros = livroRepository.findByIdIdioma(id);
		if (!livros.isEmpty()) {
			throw new EntidadeEmUsoException("Idioma com id " + id + " está em uso. Não é possível excluir");
		}

		Optional<Idioma> idioma = idiomaRepository.findById(id);
		if (idioma.isPresent()) {
			idiomaRepository.deleteById(id);
		} else {
			throw new NotFoundException("Idioma não encontrado para o id " + id);
		}
	}

	public IdiomaDTO atualizar(Long id, IdiomaDTO idiomaDTO) throws NotFoundException {
		Optional<Idioma> idioma = idiomaRepository.findById(id);
		if (idioma.isPresent()) {
			Idioma idiomaParaAtualizar = idioma.get();
			idiomaParaAtualizar.setIdioma(idiomaDTO.getIdioma());
			idiomaParaAtualizar.setSigla(idiomaDTO.getSigla());
			Idioma idiomaAlterado = idiomaRepository.save(idiomaParaAtualizar);
			return new IdiomaDTO(idiomaAlterado);
		}
		throw new NotFoundException("Idioma não encontrado para o id " + id);
	}
}
