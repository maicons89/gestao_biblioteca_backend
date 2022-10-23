package br.com.entra21.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.entra21.trabalhofinal.entity.ExemplarEmprestimo;

public interface ExemplarEmprestimoRepository extends JpaRepository<ExemplarEmprestimo, Long> {

	@Query("SELECT ep FROM ExemplarEmprestimo ep WHERE ep.dataDevolucao is null")
	List<ExemplarEmprestimo> findAllEmAberto();

	@Query("SELECT ep FROM ExemplarEmprestimo ep WHERE ep.dataDevolucao is not null")
	List<ExemplarEmprestimo> findAllDevolvidos();

}
