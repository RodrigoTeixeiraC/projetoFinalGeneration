package com.gamificacao.projetogamificacao.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamificacao.projetogamificacao.Models.Atividades;

public interface AtividadesRepository extends JpaRepository<Atividades, Long> {
	

}
