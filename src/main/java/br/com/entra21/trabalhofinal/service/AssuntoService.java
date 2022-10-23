package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.AssuntoDTO;
import br.com.entra21.trabalhofinal.entity.Assunto;
import br.com.entra21.trabalhofinal.entity.Livro;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.AssuntoRepository;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class AssuntoService {

	@Autowired
	private AssuntoRepository assuntoRepository;

	@Autowired
	private LivroRepository livroRepository;

	public List<AssuntoDTO> lista() {
		List<Assunto> assuntos = assuntoRepository.findAll();
		return AssuntoDTO.toList(assuntos);
	}

	public AssuntoDTO cadastrar(AssuntoDTO assuntoDTO) {
		Assunto assuntoParaSalvar = assuntoDTO.toEntity();
		Assunto assuntoCadastrado = assuntoRepository.save(assuntoParaSalvar);
		return new AssuntoDTO(assuntoCadastrado);
	}

	public AssuntoDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Assunto> assunto = assuntoRepository.findById(id);
		if (assunto.isPresent()) {
			return new AssuntoDTO(assunto.get());
		}

		throw new NotFoundException("Assunto não encontrado para o id " + id);

	}

	public void excluir(Long id) throws NotFoundException, EntidadeEmUsoException {

		List<Livro> livros = livroRepository.findByIdAssunto(id);
		if (!livros.isEmpty()) {
			throw new EntidadeEmUsoException("Assunto com id " + id + " está em uso. Não é possível excluir");
		}

		Optional<Assunto> assunto = assuntoRepository.findById(id);
		if (assunto.isPresent()) {
			assuntoRepository.deleteById(id);
		} else {
			throw new NotFoundException("Assunto não encontrada para o id " + id);
		}
	}

	public AssuntoDTO atualizar(Long id, AssuntoDTO assuntoDTO) throws NotFoundException {
		Optional<Assunto> assunto = assuntoRepository.findById(id);
		if (assunto.isPresent()) {
			Assunto assuntoParaAtualizar = assunto.get();
			assuntoParaAtualizar.setNome(assuntoDTO.getNome());
			assuntoParaAtualizar.setCdd(assuntoDTO.getCdd());
			Assunto assuntoAlterado = assuntoRepository.save(assuntoParaAtualizar);
			return new AssuntoDTO(assuntoAlterado);
		}
		throw new NotFoundException("Assunto não encontrada para o id " + id);
	}

}
