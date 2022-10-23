package br.com.entra21.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.entra21.trabalhofinal.entity.Exemplar;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

	@Query("SELECT e FROM Exemplar e INNER JOIN e.livro l where l.qtdDisponivelEmprestimo > 0")
	List<Exemplar> listaTodosComLivroDisponivel();
}
