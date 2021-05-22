package com.gamificacao.projetogamificacao.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import com.gamificacao.projetogamificacao.Models.Grupo;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Models.UsuarioLogin;

import com.gamificacao.projetogamificacao.Repository.GrupoRepository;

import com.gamificacao.projetogamificacao.Repository.UsuarioRepository;
import com.gamificacao.projetogamificacao.Service.UsuarioService;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/usuario")
public class UsuarioController  {

	@Autowired
	private UsuarioRepository repositoryUser;
	
	@Autowired
	private UsuarioService usuarioService;
	

	@Autowired
	private GrupoRepository grupoRepository;

	@GetMapping
	public ResponseEntity<List<Usuario>> getAll(){
		return ResponseEntity.ok(repositoryUser.findAll());
	}
	
	@GetMapping ("/id/{id}")
	public ResponseEntity<Usuario> getById (@PathVariable long id){
		return repositoryUser.findById(id).map(usuario -> ResponseEntity.ok(usuario)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/nome/sobrenome/{nome}/{sobrenome}")
	public ResponseEntity <?> getByNomeAndSobrenome (@PathVariable String nome, @PathVariable String sobrenome){
		Optional <List<Usuario>> pesquisaUsuario = repositoryUser.findAllByNomeContainingOrSobrenomeContainingIgnoreCase(nome, sobrenome);
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
	
	@PostMapping ("/logar")
	public ResponseEntity<UsuarioLogin> Autentication(@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Optional<Usuario>> Post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.cadastrarUsuario(usuario));
	}
	
	@PostMapping("/{id_usuario}/novo/grupo")
	public ResponseEntity<Usuario> novoGrupo(
			@PathVariable(value = "id_usuario") Long idUsuario,
			@Valid @RequestBody Grupo novoGrupo){
		return usuarioService.criarGrupo(novoGrupo, idUsuario)
				.map(usuarioCriador -> ResponseEntity.status(201).body(usuarioCriador))
				.orElse(ResponseEntity.status(400).build());
				
		
	}

	
	@PostMapping("/inscricao/{id_usuario}/{id_grupo}")
	public ResponseEntity<?> inscrevendoGrupo(
		@PathVariable(value = "id_usuario") Long idUsuario,
		@PathVariable(value = "id_grupo") Long idGrupo){
		return usuarioService.inscrevendoGrupo(repositoryUser.findById(idUsuario).get(), grupoRepository.findById(idGrupo).get())
				.map(inscricao -> ResponseEntity.status(201).body(inscricao))
			.orElse(ResponseEntity.status(400).build());
	}

}




