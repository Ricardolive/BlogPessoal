package br.com.generation.blogPessoal.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.generation.blogPessoal.repository.UsuarioRepository;
import br.com.generation.blogPessoal.model.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
    private UsuarioRepository  repository;
 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = repository.findByUsuario(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
             return user.map(UserDetailsImpl::new).get();
	}
	
}
	
	

 
