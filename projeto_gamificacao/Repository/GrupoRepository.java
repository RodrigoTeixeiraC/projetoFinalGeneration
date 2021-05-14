package com.gamificacao.projetogamificacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.Grupo;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Long> {

}
