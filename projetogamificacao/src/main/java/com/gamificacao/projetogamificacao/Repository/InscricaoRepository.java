package com.gamificacao.projetogamificacao.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.InscricaoGrupo;
import com.gamificacao.projetogamificacao.Models.Usuario;


@Repository
@RepositoryRestResource(path = "Inscricao", collectionResourceRel = "Inscricao", itemResourceRel = "Inscricao")
public interface InscricaoRepository extends JpaRepository<InscricaoGrupo, Long> {	
	public Optional<List<InscricaoGrupo>> findByUsuarioInscricao(Usuario usuario);
}
