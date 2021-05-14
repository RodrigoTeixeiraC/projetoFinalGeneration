package com.gamificacao.projetogamificacao.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.InscricaoGrupo;


@Repository
public interface InscricaoRepository extends JpaRepository<InscricaoGrupo, Long> {


}
