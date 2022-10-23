package br.com.entra21.trabalhofinal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.entra21.trabalhofinal.dto.ExemplarDTO;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.ExemplarService;

@RestController
@RequestMapping(value = "/api/exemplar")
public class ExemplarController {

	@Autowired
	private ExemplarService exemplarService;

	@GetMapping
	public List<ExemplarDTO> lista() {
		return exemplarService.lista();
	}

	@GetMapping("/listaTodosDisponiveis")
	public List<ExemplarDTO> listaTodosDisponiveis() {
		return exemplarService.listaTodosComLivroDisponivel();
	}

	@PostMapping
	public ResponseEntity<ExemplarDTO> cadastrar(@Valid @RequestBody ExemplarDTO exemplar) throws NotFoundException {
		return new ResponseEntity<ExemplarDTO>(exemplarService.cadastrar(exemplar), HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ExemplarDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return exemplarService.buscarPorID(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExemplarDTO> atualizar(@PathVariable Long id, @Valid @RequestBody ExemplarDTO exemplar)
			throws NotFoundException {
		return ResponseEntity.ok(exemplarService.atualizar(id, exemplar));
	}

}
