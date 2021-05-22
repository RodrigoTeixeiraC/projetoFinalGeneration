package com.gamificacao.projetogamificacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gamificacao.projetogamificacao.Models.Atividades;
import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.AtividadesRepository;
import com.gamificacao.projetogamificacao.Service.UsuarioService;

public class AtividadesController {
	
	@Autowired
	private AtividadesRepository atividadesRepository;
	
	@Autowired UsuarioService uservice;
	

	@GetMapping
	public List<Atividades> buscarAtividades (){
		
		return  uservice.buscarAtividades((Usuario) ResponseEntity.status(HttpStatus.OK));
	}
	
	/*@GetMapping("/grupos")
	public List<PostagemQuiz> buscarPostQuiz(Usuario user){
		
		return uservice.buscarPostQuiz(user);
	}*/
	
	public @PostMapping ResponseEntity<Atividades> postStatus (@RequestBody Atividades status){
		return ResponseEntity.status(201).body(atividadesRepository.save(status));
	}
	
	public @PutMapping ResponseEntity<Atividades> editarStatus (@RequestBody Atividades status){
		return ResponseEntity.status(202).body(atividadesRepository.saveAndFlush(status));
	}

}
