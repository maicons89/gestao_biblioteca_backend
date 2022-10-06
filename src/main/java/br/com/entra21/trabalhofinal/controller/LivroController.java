package br.com.entra21.trabalhofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entra21.trabalhofinal.dto.LivroDTO;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.LivroService;

@RestController
@RequestMapping(value = "/api/livro")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@GetMapping
	public List<LivroDTO> lista() {
		return livroService.lista();
	}

	@PostMapping
	public ResponseEntity<LivroDTO> cadastrar(@Valid @RequestBody LivroDTO livro) throws NotFoundException {
		return new ResponseEntity<LivroDTO>(livroService.cadastrar(livro), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public LivroDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return livroService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException {
		livroService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<LivroDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LivroDTO livro)
			throws NotFoundException {
		return ResponseEntity.ok(livroService.atualizar(id, livro));
	}

}
