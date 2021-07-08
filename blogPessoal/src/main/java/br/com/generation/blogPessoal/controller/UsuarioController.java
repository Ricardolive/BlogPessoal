package br.com.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.generation.blogPessoal.model.Postagem;
import br.com.generation.blogPessoal.model.UserLogin;
import br.com.generation.blogPessoal.model.Usuario;
import br.com.generation.blogPessoal.repository.UsuarioRepository;
import br.com.generation.blogPessoal.service.UsuarioService;
 

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	
	@Autowired
    private UsuarioService  service;
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>> findAllUsuario(){
		
		return ResponseEntity.ok(repository.findAll());	
	}
	
	@GetMapping("/id/{id}") 
	public ResponseEntity<Usuario> findByIDUsuario(@PathVariable long id){
	      return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}


	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody  Optional<UserLogin> user){
            return service.Logar(user).map(resp -> ResponseEntity.ok(resp))
                    .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
   }

  
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody  Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
	       .body(service.CadastrarUsuario(usuario));
	  }
	
	@PutMapping("/atualizar")
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario){
		return ResponseEntity.ok(repository.save(usuario));
	}
	  
	  
	  
}


