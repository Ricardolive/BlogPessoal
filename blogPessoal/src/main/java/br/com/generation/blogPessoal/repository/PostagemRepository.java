package br.com.generation.blogPessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.blogPessoal.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
	
	public Postagem findOneByTituloContainingIgnoreCase(String titulo);
 
	

}
