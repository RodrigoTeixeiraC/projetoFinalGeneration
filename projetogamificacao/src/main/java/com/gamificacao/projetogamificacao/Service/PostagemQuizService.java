package com.gamificacao.projetogamificacao.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamificacao.projetogamificacao.Models.Grupo;
import com.gamificacao.projetogamificacao.Models.PostagemQuiz;
import com.gamificacao.projetogamificacao.Repository.GrupoRepository;
import com.gamificacao.projetogamificacao.Repository.PostagemQuizRepository;

@Service
public class PostagemQuizService {

	@Autowired
	private PostagemQuizRepository repositoryPost;
	@Autowired
	private GrupoRepository repositoryGrupo;

	public PostagemQuiz save(PostagemQuiz novoPost, Long idGrupo) {
		Optional<Grupo> grupoPost = repositoryGrupo.findById(idGrupo);
		novoPost.setGrupoPostQuiz(grupoPost.get());
		return repositoryPost.save(novoPost);
	}
	/*
	 * editar post - criador do grupo apenas pode editar e postar. Necessário saber
	 * se pode ser feito apenas no front (com um botão que aparece apenas para o
	 * criador ou se é uma regra de negócio do back-end).
	 */

	public List<PostagemQuiz> listarPostsQuiz(String titulo, String mentalidade) {
		if (mentalidade.isEmpty()) {
			return repositoryPost.findAllByTituloContainingIgnoreCase(titulo);
		} else {
			return repositoryPost.findAllByTituloContainingIgnoreCase(titulo)
					.stream()
					.filter(post -> mentalidade.equals(post.getMentalidade().toString()))
					.collect(Collectors.toList());
		}
	}
}
