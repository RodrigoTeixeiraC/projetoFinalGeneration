package com.gamificacao.projetogamificacao.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamificacao.projetogamificacao.Models.Atividades;
import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Service.UsuarioService;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/atividades")
public class AtividadesController {
	
	@Autowired
	private UsuarioService uservice;
	
	@GetMapping
	public List<Atividades> buscarAtividades (){
		
		return  uservice.buscarAtividades((Usuario) ResponseEntity.status(HttpStatus.OK));
	}
	
	@GetMapping("/grupos")
	public List<PostagemQuiz> buscarPostQuiz(Usuario user){
		
		return uservice.buscarPostQuiz(user);
	}

}
