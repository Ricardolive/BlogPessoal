package br.com.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import br.com.generation.blogPessoal.model.Usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
 

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@BeforeAll
	public void start() {
	Usuario usuario = new Usuario(0L, "Ricardo", "admin", "admin123");
	if (usuarioRepository.findByUsuario(usuario.getUsuario()) == null)
		usuarioRepository.save(usuario);
	usuario = new Usuario(0L, "Ademiro", "ademir", "123456");
	if (usuarioRepository.findByUsuario(usuario.getUsuario()) == null)
		usuarioRepository.save(usuario);
	usuario = new Usuario(0L, "Rafael", "rafa", "789456");
	if (usuarioRepository.findByUsuario(usuario.getUsuario()) == null)
		usuarioRepository.save(usuario);
	usuario = new Usuario(0L, "Amigo", "amigo", "123123");
	if (usuarioRepository.findByUsuario(usuario.getUsuario()) == null)
		usuarioRepository.save(usuario);
	}
	
	
	@Test
	public void findByNomeRetornaContato() throws Exception {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("rafa");
	assertTrue(usuario.get().getUsuario().equals("rafa"));
	}
	
	
	@Test
	public void findAllByNomeIgnoreCaseRetornaTresContato() {
	List<Usuario> contatos = usuarioRepository.findAllByUsuarioIgnoreCaseContaining("rafa");
	 assertEquals(3, contatos.size());
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
	

}
