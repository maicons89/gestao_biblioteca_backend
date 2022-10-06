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

import br.com.entra21.trabalhofinal.dto.AssuntoDTO;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.AssuntoService;

@RestController
@RequestMapping(value = "/api/assunto")
public class AssuntoController {

	@Autowired
	private AssuntoService assuntoService;

	@GetMapping
	public List<AssuntoDTO> lista() {
		return assuntoService.lista();
	}

	@PostMapping
	public ResponseEntity<AssuntoDTO> cadastrar(@Valid @RequestBody AssuntoDTO assunto) {
		return new ResponseEntity<AssuntoDTO>(assuntoService.cadastrar(assunto), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public AssuntoDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return assuntoService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException, EntidadeEmUsoException {
		assuntoService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<AssuntoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody AssuntoDTO assunto)
			throws NotFoundException {
		return ResponseEntity.ok(assuntoService.atualizar(id, assunto));
	}

}
