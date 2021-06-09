package com.gamificacao.projetogamificacao.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.Tarefa;


@Repository
@RepositoryRestResource(path = "Tarefa", collectionResourceRel = "Tarefa", itemResourceRel = "Tarefa")
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
