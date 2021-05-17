package com.gamificacao.projetogamificacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.AprovacaoAmigos;

@Repository
public interface AprovacaoAmigosRepository extends JpaRepository<AprovacaoAmigos, Long> {

}
