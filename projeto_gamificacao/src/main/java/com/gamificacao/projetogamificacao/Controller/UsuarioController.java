package com.gamificacao.projetogamificacao.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.UsuarioRepository;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/usuario")
public class UsuarioController  {

	@Autowired
	private UsuarioRepository repositoryUser;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repositoryUser.findAll());
	}
	
	@GetMapping ("/id/{id}")
	public ResponseEntity<Usuario> getById (@PathVariable long idUsuario){
		return repositoryUser.findById(idUsuario).map(usuario -> ResponseEntity.ok(usuario)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/sobrenome/{nome}/{sobrenome}")
	public ResponseEntity <?> getByNomeAndSobrenome (@PathVariable String nome, @PathVariable String sobrenome){
		Optional <List<Usuario>> pesquisaUsuario = repositoryUser.FindAllByNomeContainingOrSobrenomeContainingIgnoreCase(nome, sobrenome);
		return pesquisaUsuario.map(user -> ResponseEntity.ok(user)).orElse(ResponseEntity.notFound().build()); 
	}
	
	@PostMapping
	public ResponseEntity <Usuario> post (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryUser.save(usuario));
	}
	
	@PutMapping
	public ResponseEntity <Usuario> put (@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryUser.save(usuario));
	}
	
	@DeleteMapping ("/deletar/{idUsuario}")
	public void delete (@PathVariable long idUsuario) {
		repositoryUser.deleteById(idUsuario);
	}
}




