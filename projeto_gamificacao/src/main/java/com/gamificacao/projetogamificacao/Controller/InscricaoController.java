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

import com.gamificacao.projetogamificacao.Models.Inscricao;
import com.gamificacao.projetogamificacao.Repository.InscricaoRepository;

@RestController
@RequestMapping("/inscricao")
@CrossOrigin("*")
public class InscricaoController {

	@Autowired
	private InscricaoRepository repository;

	@GetMapping
	public ResponseEntity<List<Inscricao>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Inscricao> GetById(@PathVariable Long id) {

		return repository.findById(id).map(inscricao -> ResponseEntity.ok(inscricao))
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Inscricao> post(@RequestBody Inscricao inscricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(inscricao));
	}

	@PutMapping
	public ResponseEntity<Inscricao> put(@RequestBody Inscricao inscricao) {
		return ResponseEntity.ok(repository.save(inscricao));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
