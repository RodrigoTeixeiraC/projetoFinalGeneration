package com.gamificacao.projetogamificacao.Models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class AprovacaoAmigos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Enumerated (EnumType.STRING)
	private Aprovacao aprovacao;

	@ManyToOne
	private Usuario usuarioPrincipal;
	
	@ManyToOne
	private Usuario usuarioPedindo;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Usuario getUsuarioPrincipal() {
		return usuarioPrincipal;
	}


	public void setUsuarioPrincipal(Usuario usuarioPrincipal) {
		this.usuarioPrincipal = usuarioPrincipal;
	}


	public Usuario getUsuarioPedindo() {
		return usuarioPedindo;
	}


	public void setUsuarioPedindo(Usuario usuarioPedindo) {
		this.usuarioPedindo = usuarioPedindo;
	}


	public Aprovacao getAprovacao() {
		return aprovacao;
	}


	public void setAprovacao(Aprovacao aprovacao) {
		this.aprovacao = aprovacao;
	}
	
	
}
