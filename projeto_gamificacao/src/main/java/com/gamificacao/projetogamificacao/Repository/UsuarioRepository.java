package com.gamificacao.projetogamificacao.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamificacao.projetogamificacao.Models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Optional <List<Usuario>> FindAllByNomeContainingOrSobrenomeContainingIgnoreCase (String nome, String sobrenome);   

	 public Optional<Usuario> findByUsuarioOrEmail(String userName);

	
}
