package br.com.generation.blogPessoal.repository;

  
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.generation.blogPessoal.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema,Long> {
	
	
	public  Tema findOneByDescricaoContainingIgnoreCase(String descricao);
 

}
