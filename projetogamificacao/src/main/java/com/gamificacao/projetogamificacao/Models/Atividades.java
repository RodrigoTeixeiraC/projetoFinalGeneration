package com.gamificacao.projetogamificacao.Models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.hateoas.RepresentationModel;

@Entity
public class Atividades extends RepresentationModel<Atividades> {
	
	public Atividades() {
	}
	public Atividades(String atividade, Usuario usuarioAtividade) {
		super();
		this.atividade = atividade;
		this.usuarioAtividade = usuarioAtividade;
	}
	
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) long id_atividades;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data_atividades = new java.sql.Date(System.currentTimeMillis());
	
	private String atividade;
		
	@ManyToOne
	@JoinColumn (name = "idUsuario")
	private Usuario usuarioAtividade;
	
	public long getId_atividades() {
		return id_atividades;
	}

	public void setId_atividades(long id_atividades) {
		this.id_atividades = id_atividades;
	}

	public Date getData_atividades() {
		return data_atividades;
	}

	public void setData_atividades(Date data_atividades) {
		this.data_atividades = data_atividades;
	}

	public Usuario getUsuarioAtividade() {
		return usuarioAtividade;
	}

	public void setUsuarioAtividade(Usuario usuarioAtividade) {
		this.usuarioAtividade = usuarioAtividade;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

}
