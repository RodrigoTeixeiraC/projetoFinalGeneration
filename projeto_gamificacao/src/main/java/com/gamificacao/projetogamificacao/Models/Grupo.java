package com.gamificacao.projetogamificacao.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name = "tb_grupo")

public class Grupo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min = 4, max = 14)
	private String nome;
	
	@Size (min = 10, max = 200)
	private String descricao;
	
	private String foto;
	
	private String icone;
	
	@OneToMany (mappedBy = "grupoInscricao", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<InscricaoGrupo> listaInscricao = new HashSet<>();
	
	@OneToMany (mappedBy = "grupoPostQuiz", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<PostagemQuiz> listaPostQuiz = new ArrayList<>();
	
	private long idUsuarioCriador;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	

	public Set<InscricaoGrupo> getListaInscricao() {
		return listaInscricao;
	}

	public void setListaInscricao(Set<InscricaoGrupo> listaInscricao) {
		this.listaInscricao = listaInscricao;
	}

	public List<PostagemQuiz> getListaPostQuiz() {
		return listaPostQuiz;
	}

	public void setListaPostQuiz(List<PostagemQuiz> listaPostQuiz) {
		this.listaPostQuiz = listaPostQuiz;
	}

	public long getIdUsuarioCriador() {
		return idUsuarioCriador;
	}

	public void setIdUsuarioCriador(long idUsuarioCriador) {
		this.idUsuarioCriador = idUsuarioCriador;
	}

}
