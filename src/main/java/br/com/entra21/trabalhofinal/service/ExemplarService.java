package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.ExemplarDTO;
import br.com.entra21.trabalhofinal.dto.LivroDTO;
import br.com.entra21.trabalhofinal.entity.Exemplar;
import br.com.entra21.trabalhofinal.entity.ExemplarEmprestimo;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.ExemplarEmprestimoRepository;
import br.com.entra21.trabalhofinal.repository.ExemplarRepository;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class ExemplarService {

	@Autowired
	private ExemplarRepository exemplarRepository;

	@Autowired
	private ExemplarEmprestimoRepository exemplarEmprestimoRepository;

	@Autowired
	private LivroService livroService;

	@Autowired
	private LivroRepository livroRepository;

	public List<ExemplarDTO> lista() {
		List<Exemplar> exemplares = exemplarRepository.findAll();
		return ExemplarDTO.toList(exemplares);
	}

	public List<ExemplarDTO> listaTodosComLivroDisponivel() {
		List<Exemplar> exemplares = exemplarRepository.listaTodosComLivroDisponivel();
		List<ExemplarEmprestimo> emprestimos = exemplarEmprestimoRepository.findAllEmAberto();
		emprestimos.forEach(e -> {
			exemplares.removeIf(exemplar -> exemplar.getId() == e.getExemplar().getId());
		});
		return ExemplarDTO.toList(exemplares);
	}

	public ExemplarDTO cadastrar(ExemplarDTO exemplarDTO) throws NotFoundException {
		Exemplar exemplarParaSalvar = exemplarDTO.toEntity();

		LivroDTO livroDTO = livroService.buscarPorID(exemplarDTO.getIdLivro());
		exemplarParaSalvar.setLivro(livroDTO.toEntity());

		addQtdLivroDisponível(livroDTO);

		Exemplar exemplarCadastrado = exemplarRepository.save(exemplarParaSalvar);
		return new ExemplarDTO(exemplarCadastrado);
	}

	private void addQtdLivroDisponível(LivroDTO livroDTO) {
		Long quantidadeDisponivel = livroDTO.getQtdDisponivelEmprestimo() + 1;
		livroDTO.setQtdDisponivelEmprestimo(quantidadeDisponivel);
		livroRepository.save(livroDTO.toEntity());
	}

	public ExemplarDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Exemplar> exemplar = exemplarRepository.findById(id);
		if (exemplar.isPresent()) {
			return new ExemplarDTO(exemplar.get());
		}

		throw new NotFoundException("Exemplar não encontrado para o id " + id);

	}

	public ExemplarDTO atualizar(Long id, ExemplarDTO exemplarDTO) throws NotFoundException {
		Optional<Exemplar> exemplar = exemplarRepository.findById(id);
		if (exemplar.isPresent()) {
			Exemplar exemplarParaAtualizar = exemplar.get();
			exemplarParaAtualizar.setCodigoExemplar(exemplarDTO.getCodigoExemplar());
			exemplarParaAtualizar.setDescricao(exemplarDTO.getDescricao());
			exemplarParaAtualizar.setIdLivro(exemplarDTO.getIdLivro());

			LivroDTO livroDTO = livroService.buscarPorID(exemplarDTO.getIdLivro());
			exemplarParaAtualizar.setLivro(livroDTO.toEntity());

			Exemplar exemplarAlterado = exemplarRepository.save(exemplarParaAtualizar);
			return new ExemplarDTO(exemplarAlterado);
		}
		throw new NotFoundException("Exemplar não encontrado para o id " + id);
	}

}
