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

import br.com.entra21.trabalhofinal.dto.ExemplarEmprestimoDTO;
import br.com.entra21.trabalhofinal.exception.NotFoundException;
import br.com.entra21.trabalhofinal.service.ExemplarEmprestimoService;

@RestController
@RequestMapping(value = "/api/exemplarEmprestimo")
public class ExemplarEmprestimoController {

	@Autowired
	private ExemplarEmprestimoService exemplarEmprestimoService;

	@GetMapping("/emAberto")
	public List<ExemplarEmprestimoDTO> listaEmprestimosEmAberto() {
		return exemplarEmprestimoService.listaEmprestimosEmAberto();
	}

	@GetMapping("/devolvidos")
	public List<ExemplarEmprestimoDTO> listaEmprestimosDevolvidos() {
		return exemplarEmprestimoService.listaEmprestimosDevolvidos();
	}

	@GetMapping
	public List<ExemplarEmprestimoDTO> listaTodos() {
		return exemplarEmprestimoService.listaTodos();
	}

	@PostMapping
	public ResponseEntity<ExemplarEmprestimoDTO> reservarExemplar(
			@Valid @RequestBody ExemplarEmprestimoDTO exemplarEmprestimo) throws NotFoundException {
		return new ResponseEntity<ExemplarEmprestimoDTO>(exemplarEmprestimoService.reservarExemplar(exemplarEmprestimo),
				HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ExemplarEmprestimoDTO buscarPorID(@PathVariable Long id) throws NotFoundException {
		return exemplarEmprestimoService.buscarPorID(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExemplarEmprestimoDTO> atualizar(@PathVariable Long id,
			@Valid @RequestBody ExemplarEmprestimoDTO exemplarEmprestimo) throws NotFoundException {
		return ResponseEntity.ok(exemplarEmprestimoService.atualizar(id, exemplarEmprestimo));
	}

}
