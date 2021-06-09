package com.gamificacao.projetogamificacao.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.Atividades;

@Repository
@RepositoryRestResource(path = "Atividades", collectionResourceRel = "Atividades", itemResourceRel = "Atividades")
public interface AtividadesRepository extends JpaRepository<Atividades, Long> {	
}
