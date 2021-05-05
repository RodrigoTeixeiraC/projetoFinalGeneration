package com.gamificacao.projetogamificacao.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.Inscricao;


@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {


}
