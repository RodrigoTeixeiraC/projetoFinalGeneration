package com.gamificacao.projetogamificacao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gamificacao.projetogamificacao.Models.Grupo;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.GrupoRepository;
import org.springframework.web.bind.annotation.PutMapping;


import com.gamificacao.projetogamificacao.Models.Aprovacao;
import com.gamificacao.projetogamificacao.Service.GrupoService;

@RestController
@RequestMapping("/grupo")
@CrossOrigin("*")
public class GrupoController {
	
	private @Autowired GrupoRepository repositoryGrupo;
	private @Autowired GrupoService serviceGrupo;

	@GetMapping
	public ResponseEntity<List<Grupo>> getAllGrupos(){
		List<Grupo> listaGrupos = repositoryGrupo.findAll();
		for (Grupo grupo: listaGrupos) {
			long id = grupo.getId();
			@SuppressWarnings("deprecation")
			Link selfLink = new Link("http://localhost:8080/grupo/"+id);
			grupo.add(selfLink);
		}
		return ResponseEntity.ok(listaGrupos);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getGrupoById(@Valid @PathVariable long id){
		Grupo grupo = repositoryGrupo.findById(id).get();
		@SuppressWarnings("deprecation")
		Link selfLink = new Link("http://localhost:8080/grupo");
		grupo.add(selfLink);
		@SuppressWarnings("deprecation")
		Link criadorLink = new Link("http://localhost:8080/usuario/"+grupo.getCriador().getId());
		grupo.getCriador().add(criadorLink);
		return ResponseEntity.ok(grupo);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteGrupoById(@Valid @PathVariable long id){
		repositoryGrupo.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body(null); 		
	}
	@PutMapping("/aceitar/{id_inscricao}")
	public ResponseEntity<?> aceitarInscricao(
			@PathVariable (value= "id_inscricao") Long idInscricao)
			{ serviceGrupo.aceitarUsuario(idInscricao);
				return ResponseEntity.status(HttpStatus.OK).body((Aprovacao.APROVADO));
	}
	@PutMapping("/rejeitar/{id}")
	public ResponseEntity<Aprovacao> negarInscricao(@PathVariable( value="id") Long id){
		serviceGrupo.rejeitarUsuario(id);
		return ResponseEntity.status(HttpStatus.OK).body(Aprovacao.NEGADO); 
		
	}
}


