package com.gamificacao.projetogamificacao.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.Models.AprovacaoAmigos;
import com.gamificacao.projetogamificacao.Models.Atividades;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.AtividadesRepository;
import com.gamificacao.projetogamificacao.Repository.UsuarioRepository;

@Service
public class AtividadesService {

	private @Autowired UsuarioRepository usuarioRepository;
	private @Autowired AtividadesRepository atividadesRepository;

	/**
	* Criar uma atividade 
	*
	*@param atividades uma entidade de Atividades
	*@param idUsuario tipo Long
	*@return Optional com o usuario e suas atividades ou uma Optional vazio.
	*
	*@since 1.0
	*@author Allan 
	*/
		public Optional<Usuario> criarAtividade (Long idUsuario, Atividades atividades){
		return usuarioRepository.findById(idUsuario).map(usuarioExistente -> {
			atividades.setUsuarioAtividade(usuarioExistente);
			atividadesRepository.save(atividades);
			return usuarioRepository.findById(idUsuario);
		}).orElse(Optional.empty());
	}
	/**
	* Pegar todas as atividades dos amigos 
	*
	*@param usuario uma entidade de Usuario
	*@return As atividades feitas pelos amigos.
	*
	*@since 1.0
	*@author Allan 
	*/
	public List<Atividades> atividadesAmigos(Usuario usuario) {
		List<AprovacaoAmigos> amigos = usuario.getMeusPedidosAmizade();
		List<Atividades> listaAtividades = new ArrayList<>();
		amigos.forEach(amigo -> listaAtividades.addAll(amigo.getUsuarioPedindo().getAtividadesUsuario()));
		return listaAtividades;
	}
}
