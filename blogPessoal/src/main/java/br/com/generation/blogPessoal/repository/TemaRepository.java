package br.com.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.generation.blogPessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema,Long> {
	
	
	public  Tema findOneByDescricaoContainingIgnoreCase(String descricao);
 

}
