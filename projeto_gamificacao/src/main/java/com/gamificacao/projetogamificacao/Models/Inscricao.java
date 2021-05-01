package com.gamificacao.projetogamificacao.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_inscricao")
public class Inscricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private enum aprovacao {
		APROVADO, NEGADO, AGUARDANDO 
	};
	
	@NotNull
	private long fkUsuario;
	
	@NotNull
	private long fkGrupo;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(long fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public long getFkGrupo() {
		return fkGrupo;
	}

	public void setFkGrupo(long fkGrupo) {
		this.fkGrupo = fkGrupo;
	}
	
	

}
