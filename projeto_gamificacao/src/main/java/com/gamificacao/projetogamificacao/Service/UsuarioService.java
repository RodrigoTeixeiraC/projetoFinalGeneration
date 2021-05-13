package com.gamificacao.projetogamificacao.Service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Models.UsuarioLogin;
import com.gamificacao.projetogamificacao.Repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public Optional<Usuario> cadastrarUsuario (Usuario usuario){
		
		Optional<Usuario> usuarioExistente = repository.findByUsuarioOrEmail(usuario.getUsuario(), usuario.getEmail());
		
		if (usuarioExistente.isPresent()) {
			return Optional.empty();
		}
		else {
			BCryptPasswordEncoder ecoder = new BCryptPasswordEncoder();
			
			String senhaEcoder = ecoder.encode(usuario.getSenha());
			usuario.setSenha(senhaEcoder);
			
			return Optional.ofNullable(repository.save(usuario));
		}
	}
	
	public Optional<UsuarioLogin> Logar (Optional<UsuarioLogin> user){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Usuario> usuario = repository.findByUsuarioOrEmail(user.get().getUsuario(), user.get().getUsuario());
		
		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha()));
			
			String auth = user.get().getUsuario() + ":" + user.get().getSenha();
			byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
			String authHeader = "Basic " + new String (encodeAuth);
			
			user.get().setToken(authHeader);
			
			return user;
		}
		return null;
	}
	
}
