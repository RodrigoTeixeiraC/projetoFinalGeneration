package com.gamificacao.projetogamificacao.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.Models.Atividades;
import com.gamificacao.projetogamificacao.Models.InscricaoGrupo;
import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Models.Usuario;
import com.gamificacao.projetogamificacao.Repository.AtividadesRepository;
import com.gamificacao.projetogamificacao.Repository.UsuarioRepository;

@Service
public class AtividadesService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private AtividadesRepository atividadesRepository;

	/**
	* Criar um status e o usuario que criou 
	*
	*@param atividades uma entidade de Atividades
	*@param idUsuario tipo Long
	*@return Optional com o usuario e suas atividades ou uma Optional vazio.
	*
	*@since 1.0
	*@author Allan 
	*/
	
	public Optional<Usuario> status (Long idUsuario, Atividades atividades){
		return usuarioRepository.findById(idUsuario).map(usuarioExistente -> {
			atividades.setUsuarioAtividade(usuarioExistente);
			atividadesRepository.save(atividades);
			return usuarioRepository.findById(idUsuario);
		}).orElse(Optional.empty());
	}
	

	/**
	* Mostra os grupos que os amigos fazem parte
	*
	*@param usuario uma entidade de Usuario
	*@return Uma lista dos grupos que os amigos fazem parte.
	*
	*@since 1.0
	*@author Allan 
	*/

	public List<InscricaoGrupo> gruposDosAmigos(Usuario usuario) {

		Set<Usuario> listaAmigos = usuario.getClan();
		List<InscricaoGrupo> gruposInscritos = usuario.getListaInscricaoUG();

		for (Usuario x : listaAmigos) {

			for (InscricaoGrupo y : gruposInscritos) {
				return gruposInscritos;
			}
		}
		return null;
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

		Set<Usuario> listaAmigos = usuario.getClan();
		List<Atividades> atividades = usuario.getAtividadesUsuario();

		for (Usuario i : listaAmigos) {

			for (Atividades x : atividades) {

				return atividades;
			}
		}
		return null;
	}
	
	

	/*public Atividades pontuacao (Usuario usuario, PostagemQuiz postQuiz) {
		
		Atividades atividadePontuacao = new Atividades( String.valueOf(postQuiz.getPontuacao()), " ", usuario);
		atividadesRepository.save(atividadePontuacao);
		
		return atividadePontuacao;
	}*/
}
