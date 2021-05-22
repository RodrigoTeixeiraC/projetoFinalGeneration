package com.gamificacao.projetogamificacao.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.PostagemQuiz;

@Repository
public interface PostagemQuizRepository extends JpaRepository<PostagemQuiz, Long> {
	public List<PostagemQuiz> findAllByTituloContainingIgnoreCase(String titulo);
	

}
