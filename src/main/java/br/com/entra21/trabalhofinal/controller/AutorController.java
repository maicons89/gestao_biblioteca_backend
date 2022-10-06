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

import br.com.entra21.trabalhofinal.dto.AutorDTO;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.AutorService;

@RestController
@RequestMapping(value = "/api/autor")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping
	public List<AutorDTO> lista() {
		return autorService.lista();
	}

	@PostMapping
	public ResponseEntity<AutorDTO> cadastrar(@Valid @RequestBody AutorDTO autor) {
		return new ResponseEntity<AutorDTO>(autorService.cadastrar(autor), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public AutorDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return autorService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException, EntidadeEmUsoException {
		autorService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<AutorDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AutorDTO autor)
			throws NotFoundException {
		return ResponseEntity.ok(autorService.atualizar(id, autor));
	}

}
