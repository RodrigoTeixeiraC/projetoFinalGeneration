package com.gamificacao.projetogamificacao.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.Grupo;
import com.gamificacao.projetogamificacao.Models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional <List<Usuario>> findAllByNomeContainingOrSobrenomeContainingIgnoreCase (String nome, String sobrenome);   

	 public Optional<Usuario> findByUsuarioOrEmail(String userName, String email);
	 
	 public Set<Usuario> findByClan ( Usuario clan);
}
