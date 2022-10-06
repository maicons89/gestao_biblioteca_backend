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

import br.com.entra21.trabalhofinal.dto.IdiomaDTO;
import br.com.entra21.trabalhofinal.exception.EntidadeEmUsoException;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.IdiomaService;

@RestController
@RequestMapping(value = "/api/idioma")
public class IdiomaController {

	@Autowired
	private IdiomaService idiomaService;

	@GetMapping
	public List<IdiomaDTO> lista() {
		return idiomaService.lista();
	}

	@PostMapping
	public ResponseEntity<IdiomaDTO> cadastrar(@Valid @RequestBody IdiomaDTO idioma) {
		return new ResponseEntity<IdiomaDTO>(idiomaService.cadastrar(idioma), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public IdiomaDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return idiomaService.buscarPorID(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) throws NotFoundException, EntidadeEmUsoException {
		idiomaService.excluir(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<IdiomaDTO> atualizar(@PathVariable Long id, @Valid @RequestBody IdiomaDTO idioma)
			throws NotFoundException {
		return ResponseEntity.ok(idiomaService.atualizar(id, idioma));
	}
}
