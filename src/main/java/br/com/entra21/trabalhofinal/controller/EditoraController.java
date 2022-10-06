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

import br.com.entra21.trabalhofinal.dto.EditoraDTO;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.EditoraService;

@RestController
@RequestMapping(value = "/api/editora")
public class EditoraController {

	@Autowired
	private EditoraService editoraService;

	@GetMapping
	public List<EditoraDTO> lista() {
		return editoraService.lista();
	}

	@PostMapping
	public ResponseEntity<EditoraDTO> cadastrar(@Valid @RequestBody EditoraDTO editora) {
		return new ResponseEntity<EditoraDTO>(editoraService.cadastrar(editora), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public EditoraDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return editoraService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException, EntidadeEmUsoException {
		editoraService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<EditoraDTO> atualizar(@PathVariable Long id, @Valid @RequestBody EditoraDTO editora) {
		return ResponseEntity.ok(editoraService.atualizar(id, editora));
	}
}
