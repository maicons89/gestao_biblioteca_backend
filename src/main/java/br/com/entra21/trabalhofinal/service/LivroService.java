package br.com.entra21.trabalhofinal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.entra21.trabalhofinal.dto.AssuntoDTO;
import br.com.entra21.trabalhofinal.dto.AutorDTO;
import br.com.entra21.trabalhofinal.dto.EditoraDTO;
import br.com.entra21.trabalhofinal.dto.IdiomaDTO;
import br.com.entra21.trabalhofinal.dto.LivroDTO;
import br.com.entra21.trabalhofinal.entity.Livro;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private EditoraService editoraService;

	@Autowired
	private AssuntoService assuntoService;

	@Autowired
	private AutorService autorService;

	@Autowired
	private IdiomaService idiomaService;

	public List<LivroDTO> lista() {
		List<Livro> livros = livroRepository.findAll();
		return LivroDTO.toList(livros);
	}

	public LivroDTO cadastrar(LivroDTO livroDTO) throws NotFoundException {
		Livro livroParaSalvar = livroDTO.toEntity();

		EditoraDTO editoraDTO = editoraService.buscarPorID(livroDTO.getIdEditora());
		livroParaSalvar.setEditora(editoraDTO.toEntity());

		AssuntoDTO assuntoDTO = assuntoService.buscarPorID(livroDTO.getIdAssunto());
		livroParaSalvar.setAssunto(assuntoDTO.toEntity());

		AutorDTO autorDTO = autorService.buscarPorID(livroDTO.getIdAutor());
		livroParaSalvar.setAutor(autorDTO.toEntity());

		IdiomaDTO idiomaDTO = idiomaService.buscarPorID(livroDTO.getIdIdioma());
		livroParaSalvar.setIdioma(idiomaDTO.toEntity());

		Livro livroCadastro = livroRepository.save(livroParaSalvar);
		return new LivroDTO(livroCadastro);
	}

	public LivroDTO buscarPorID(Long id) throws NotFoundException {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			return new LivroDTO(livro.get());
		}
		throw new NotFoundException("Livro não encontrado para o id " + id);
	}

	public void excluir(Long id) throws NotFoundException {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			livroRepository.deleteById(id);
		} else {
			throw new NotFoundException("Livro não encontrada para o id " + id);
		}
	}

	public LivroDTO atualizar(Long id, LivroDTO livroDTO) throws NotFoundException {
		Optional<Livro> livro = livroRepository.findById(id);
		if (livro.isPresent()) {
			Livro livroParaAtualizar = livro.get();
			livroParaAtualizar.setIsbn(livroDTO.getIsbn());
			livroParaAtualizar.setTituloPrincipal(livroDTO.getTituloPrincipal());
			livroParaAtualizar.setFormasVariantesDoTitulo(livroDTO.getFormasVariantesDoTitulo());
			livroParaAtualizar.setNumeroEdicao(livroDTO.getNumeroEdicao());
			livroParaAtualizar.setDescricaoFisica(livroDTO.getDescricaoFisica());
			livroParaAtualizar.setQtdDisponivelEmprestimo(livroDTO.getQtdDisponivelEmprestimo());
			livroParaAtualizar.setDescricao(livroDTO.getDescricao());
			livroParaAtualizar.setStatus(livroDTO.getStatus());
			livroParaAtualizar.setIdAssunto(livroDTO.getIdAssunto());
			livroParaAtualizar.setIdEditora(livroDTO.getIdEditora());
			livroParaAtualizar.setIdAutor(livroDTO.getIdAutor());
			livroParaAtualizar.setIdIdioma(livroDTO.getIdIdioma());

			EditoraDTO editoraDTO = editoraService.buscarPorID(livroDTO.getIdEditora());
			livroParaAtualizar.setEditora(editoraDTO.toEntity());

			AssuntoDTO assuntoDTO = assuntoService.buscarPorID(livroDTO.getIdAssunto());
			livroParaAtualizar.setAssunto(assuntoDTO.toEntity());

			AutorDTO autorDTO = autorService.buscarPorID(livroDTO.getIdAutor());
			livroParaAtualizar.setAutor(autorDTO.toEntity());

			IdiomaDTO idiomaDTO = idiomaService.buscarPorID(livroDTO.getIdIdioma());
			livroParaAtualizar.setIdioma(idiomaDTO.toEntity());

			Livro livroAlterado = livroRepository.save(livroParaAtualizar);
			return new LivroDTO(livroAlterado);
		}
		throw new NotFoundException("Livro não encontrado para o id " + id);
	}

}
