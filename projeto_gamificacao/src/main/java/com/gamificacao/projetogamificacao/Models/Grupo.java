package com.gamificacao.projetogamificacao.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name = "tb_grupo")

public class Grupo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id_grupo;
	
	@NotNull
	@Size (min = 4, max = 14)
	private String nome;
	
	@Size (min = 10, max = 200)
	private String descricao;
	
	private String foto;
	
	private String icone;
	
	@NotNull
	private int id_usuarios;
	
	@OneToMany (mappedBy = "grupoInscricao", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Inscricao> listaInscricao;

	@ManyToOne 
	@JoinColumn (name = "idCriador")
	private Usuario usuarioCriador;
	
	@OneToMany (mappedBy = "grupoPostQuiz", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<PostagemQuiz> listaPostQuiz = new ArrayList<>();
	
	public long getId_grupo() {
		return id_grupo;
	}

	public void setId_grupo(long id_grupo) {
		this.id_grupo = id_grupo;
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
	
	public int getId_usuarios() {
		return id_usuarios;
	}

	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}

	public List<Inscricao> getListaInscricao() {
		return listaInscricao;
	}

	public void setListaInscricao(List<Inscricao> listaInscricao) {
		this.listaInscricao = listaInscricao;
	}

	public Usuario getUsuarioCriador() {
		return usuarioCriador;
	}

	public void setUsuarioCriador(Usuario usuarioCriador) {
		this.usuarioCriador = usuarioCriador;
	}

	public List<PostagemQuiz> getListaPostQuiz() {
		return listaPostQuiz;
	}

	public void setListaPostQuiz(List<PostagemQuiz> listaPostQuiz) {
		this.listaPostQuiz = listaPostQuiz;
	}

}
