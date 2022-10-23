package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.ExemplarDTO;
import br.com.entra21.trabalhofinal.dto.ExemplarEmprestimoDTO;
import br.com.entra21.trabalhofinal.dto.LivroDTO;
import br.com.entra21.trabalhofinal.dto.UsuarioDTO;
import br.com.entra21.trabalhofinal.entity.ExemplarEmprestimo;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.ExemplarEmprestimoRepository;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class ExemplarEmprestimoService {

	@Autowired
	private ExemplarEmprestimoRepository exemplarEmprestimoRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private ExemplarService exemplarService;

	@Autowired
	private LivroService livroService;

	@Autowired
	private UsuarioService usuarioService;

	public List<ExemplarEmprestimoDTO> listaEmprestimosEmAberto() {
		List<ExemplarEmprestimo> exemplaresEmprestimos = exemplarEmprestimoRepository.findAllEmAberto();
		return ExemplarEmprestimoDTO.toList(exemplaresEmprestimos);
	}

	public List<ExemplarEmprestimoDTO> listaTodos() {
		List<ExemplarEmprestimo> exemplaresEmprestimos = exemplarEmprestimoRepository.findAll();
		return ExemplarEmprestimoDTO.toList(exemplaresEmprestimos);
	}

	public List<ExemplarEmprestimoDTO> listaEmprestimosDevolvidos() {
		List<ExemplarEmprestimo> exemplaresEmprestimos = exemplarEmprestimoRepository.findAllDevolvidos();
		return ExemplarEmprestimoDTO.toList(exemplaresEmprestimos);
	}

	public ExemplarEmprestimoDTO reservarExemplar(ExemplarEmprestimoDTO exemplarEmprestimoDTO)
			throws NotFoundException {
		ExemplarEmprestimo exemplarEmprestimoParaSalvar = exemplarEmprestimoDTO.toEntity();

		ExemplarDTO exemplarDTO = exemplarService.buscarPorID(exemplarEmprestimoDTO.getIdExemplar());
		exemplarEmprestimoParaSalvar.setExemplar(exemplarDTO.toEntity());
		UsuarioDTO usuarioDTO = usuarioService.buscarPorID(exemplarEmprestimoDTO.getIdUsuario());
		exemplarEmprestimoParaSalvar.setUsuario(usuarioDTO.toEntity());

		LivroDTO livroDTO = livroService.buscarPorID(exemplarDTO.getIdLivro());
		diminuiQtdLivroDisponível(livroDTO);
		exemplarEmprestimoDTO.setExemplar(exemplarDTO.toEntity());
		exemplarEmprestimoDTO.getExemplar().setLivro(livroDTO.toEntity());

		ExemplarEmprestimo exemplarEmprestimoCadastrado = exemplarEmprestimoRepository
				.save(exemplarEmprestimoParaSalvar);
		return new ExemplarEmprestimoDTO(exemplarEmprestimoCadastrado);
	}

	private void diminuiQtdLivroDisponível(LivroDTO livroDTO) {
		Long quantidadeDisponivel = livroDTO.getQtdDisponivelEmprestimo() - 1;
		livroDTO.setQtdDisponivelEmprestimo(quantidadeDisponivel);
		livroRepository.save(livroDTO.toEntity());
	}

	private void aumentaQtdLivroDisponível(LivroDTO livroDTO) {
		Long quantidadeDisponivel = livroDTO.getQtdDisponivelEmprestimo() + 1;
		livroDTO.setQtdDisponivelEmprestimo(quantidadeDisponivel);
		livroRepository.save(livroDTO.toEntity());
	}

	public ExemplarEmprestimoDTO buscarPorID(Long id) throws NotFoundException {
		Optional<ExemplarEmprestimo> exemplarEmprestimo = exemplarEmprestimoRepository.findById(id);
		if (exemplarEmprestimo.isPresent()) {
			return new ExemplarEmprestimoDTO(exemplarEmprestimo.get());
		}
		throw new NotFoundException("Empréstimo não encontrado para o id " + id);
	}

	public ExemplarEmprestimoDTO atualizar(Long id, ExemplarEmprestimoDTO exemplarEmprestimoDTO)
			throws NotFoundException {
		Optional<ExemplarEmprestimo> exemplar = exemplarEmprestimoRepository.findById(id);
		if (exemplar.isPresent()) {
			ExemplarEmprestimo exemplarEmprestimoParaAtualizar = exemplar.get();
			exemplarEmprestimoParaAtualizar.setDataDevolucao(exemplarEmprestimoDTO.getDataDeveolucao());

			ExemplarDTO exemplarDTO = exemplarService.buscarPorID(exemplarEmprestimoDTO.getIdExemplar());
			exemplarEmprestimoParaAtualizar.setExemplar(exemplarDTO.toEntity());
			UsuarioDTO usuarioDTO = usuarioService.buscarPorID(exemplarEmprestimoDTO.getIdUsuario());
			exemplarEmprestimoParaAtualizar.setUsuario(usuarioDTO.toEntity());

			LivroDTO livroDTO = livroService.buscarPorID(exemplarDTO.getIdLivro());
			aumentaQtdLivroDisponível(livroDTO);
			exemplarEmprestimoDTO.setExemplar(exemplarDTO.toEntity());
			exemplarEmprestimoDTO.getExemplar().setLivro(livroDTO.toEntity());

			ExemplarEmprestimo exemplarEmprestimoAlterado = exemplarEmprestimoRepository
					.save(exemplarEmprestimoParaAtualizar);
			return new ExemplarEmprestimoDTO(exemplarEmprestimoAlterado);
		}

		throw new NotFoundException("Empréstimo não encontrado para o id " + id);
	}

}
