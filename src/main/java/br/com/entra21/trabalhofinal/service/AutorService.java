package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.AutorDTO;
import br.com.entra21.trabalhofinal.entity.Autor;
import br.com.entra21.trabalhofinal.entity.Livro;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.AutorRepository;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	@Autowired
	private LivroRepository livroRepository;

	public List<AutorDTO> lista() {
		List<Autor> autores = autorRepository.findAll();
		return AutorDTO.toList(autores);
	}

	public AutorDTO cadastrar(AutorDTO autorDTO) {
		Autor autorParaSalvar = autorDTO.toEntity();
		Autor autorCadastrado = autorRepository.save(autorParaSalvar);
		return new AutorDTO(autorCadastrado);
	}

	public AutorDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isPresent()) {
			return new AutorDTO(autor.get());
		}

		throw new NotFoundException("Autor não encontrado para o id " + id);

	}

	public void excluir(Long id) throws NotFoundException, EntidadeEmUsoException {

		List<Livro> livros = livroRepository.findByIdAutor(id);
		if (!livros.isEmpty()) {
			throw new EntidadeEmUsoException("Autor com id " + id + " está em uso. Não é possível excluir");
		}

		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isPresent()) {
			autorRepository.deleteById(id);
		} else {
			throw new NotFoundException("Autor não encontrado para o id " + id);
		}
	}

	public AutorDTO atualizar(Long id, AutorDTO autorDTO) throws NotFoundException {
		Optional<Autor> autor = autorRepository.findById(id);
		if (autor.isPresent()) {
			Autor autorParaAtualizar = autor.get();
			autorParaAtualizar.setNome(autorDTO.getNome());
			autorParaAtualizar.setDataNascimento(autorDTO.getDataNascimento());
			autorParaAtualizar.setDataFalecimento(autorDTO.getDataFalecimento());
			autorParaAtualizar.setCodigoCutter(autorDTO.getCodigoCutter());
			Autor autorAlterado = autorRepository.save(autorParaAtualizar);
			return new AutorDTO(autorAlterado);
		}
		throw new NotFoundException("Autor não encontrado para o id " + id);
	}

}
