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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamificacao.projetogamificacao.Models.Grupo;
import com.gamificacao.projetogamificacao.Repository.GrupoRepository;

@RestController
@RequestMapping("/grupo")
@CrossOrigin("*")
public class GrupoController {
	
	private @Autowired GrupoRepository repositoryGrupo;
	
	@GetMapping("/buscar/todos")
	public ResponseEntity<List<Grupo>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryGrupo.findAll());
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> getById(@Valid @PathVariable long id){
		return repositoryGrupo.findById(id)
				.map(grupo -> ResponseEntity.ok(grupo))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<?> deleteById(@Valid @PathVariable long id){
		repositoryGrupo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null); 		
	}

}
