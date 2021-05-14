package com.gamificacao.projetogamificacao.controller;

import java.util.List;

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

import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Repository.PostagemQuizRepository;

@RestController
@RequestMapping("/postagem-quiz")
@CrossOrigin("*")
public class PostagemQuizController {
	
	@Autowired
	private PostagemQuizRepository repository;
	
	public @GetMapping ("/todas") ResponseEntity<List<PostagemQuiz>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	public @GetMapping ("/{id}") ResponseEntity<PostagemQuiz> GetById (@PathVariable long id){
		return repository.findById(id).map (postQuiz -> ResponseEntity.ok(postQuiz)).orElse(ResponseEntity.notFound().build());
	}	
	
	
	public @PostMapping ResponseEntity<PostagemQuiz> post (@RequestBody PostagemQuiz postagemQuiz){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagemQuiz));
	}
	
	public @PutMapping ResponseEntity<PostagemQuiz> put (@RequestBody PostagemQuiz postagemQuiz){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagemQuiz));
	}
	
	@DeleteMapping ("/deletar/{idPostagem}")
	public void delete (@PathVariable long idPostagem) {
		repository.deleteById(idPostagem);
	}

}
