package br.com.entra21.trabalhofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.entra21.trabalhofinal.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	List<Livro> findByIdEditora(Long idEditora);

	List<Livro> findByIdAutor(Long idAutor);

	List<Livro> findByIdAssunto(Long idAssunto);

	List<Livro> findByIdIdioma(Long idIdioma);

}
