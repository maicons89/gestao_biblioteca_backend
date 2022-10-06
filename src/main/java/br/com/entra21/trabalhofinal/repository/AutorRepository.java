package br.com.entra21.trabalhofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.trabalhofinal.entity.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
