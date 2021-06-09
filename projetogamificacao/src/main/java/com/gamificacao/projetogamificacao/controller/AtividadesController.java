package com.gamificacao.projetogamificacao.controller;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamificacao.projetogamificacao.Models.Atividades;
import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.AtividadesRepository;
import com.gamificacao.projetogamificacao.Service.AtividadesService;
import com.gamificacao.projetogamificacao.Service.UsuarioService;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/atividades")
public class AtividadesController {
	
	@Autowired
	private AtividadesRepository atividadesRepository;
	
	@Autowired UsuarioService usuarioService;
	
	@Autowired AtividadesService atividadesService;
	
	@GetMapping ("/{id_atividades}")
	public Optional<Atividades> getAtividades (@PathVariable Long id_atividades){
		return atividadesRepository.findById(id_atividades);
	}
	
	@GetMapping ("/todas")
	public Optional<List<Atividades>> getAll (){
		return Optional.ofNullable(atividadesRepository.findAll());
	}
	
	/*@GetMapping("/grupos-dos-amigos")
	public List<InscricaoGrupo> gruposDosAmigos (Usuario usuario){
		
		return atividadesService.gruposDosAmigos(usuario);
	}
	
	@GetMapping ("/atividades-amigos")
	public List<Atividades> buscarAtividades (){
		return  atividadesService.atividadesAmigos((Usuario) ResponseEntity.status(HttpStatus.OK));
	}*/
	
	@GetMapping("/postagem-grupos")
	public List<PostagemQuiz> buscarPostQuiz(Usuario user){
		return usuarioService.buscarPostQuiz(user);
	}
	
	/*public @PostMapping ("/status/{idUsuario}") ResponseEntity<Optional<Usuario>> postStatus 
	(@PathVariable(value = "idUsuario") Long idUsuario,
			@Valid @RequestBody Atividades status){
		return   ResponseEntity.status(201).body(atividadesService.status(idUsuario, status));
	}*/
	
	public @PutMapping ("/editar-status") ResponseEntity<Atividades> editarStatus
	( @RequestBody Atividades novoStatus){
		return ResponseEntity.status(202).body(atividadesRepository.saveAndFlush(novoStatus));
	}
	
	@DeleteMapping ("/deletar-status/{id_atividades}") 
	public void  deleteStatus (@PathVariable Long id_atividades) {
		atividadesRepository.deleteById(id_atividades);
	}
	
	@GetMapping("/status/{status}")
	
	public ResponseEntity<Optional<Atividades>> findStatus (@PathVariable String status){
		return ResponseEntity.ok(atividadesRepository.findByStatus(status));
	}
	

}
