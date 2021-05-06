package com.gamificacao.projetogamificacao.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;


@Entity
@Table (name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String sobrenome;
	
	@NotNull
	@Email
	@UniqueElements // pesquisar sobre essa notação e sobre @UniqueConstraint
	private String email;
	
	@NotNull
	private long celular;
	
	@NotNull
	private Date dataNascimento; //foi incluido o java.util verificar se está certo(outro é sql)
	
	private int responsabilidadePessoal; //Discutir se será NotNull
	
	private int mentalidadeCrescimento;//Discutir se será NotNull
	
	private int orientacaoFuturo;//Discutir se será NotNull
	
	private int persistencia;//Discutir se será NotNull
	
	private String clan;
	
	@NotNull
	private String senha;
	
	private String foto;
	
	@NotNull
	private String avatar; //Substitui icone, verificar com grupo
	
	@OneToMany (mappedBy = "usuarioInscricao", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Inscricao> listaInscricao;
	
	@OneToMany (mappedBy = "usuarioCriador", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Grupo> gruposCriados = new ArrayList<>();
	
	@OneToMany (mappedBy = "usuarioPostQuiz", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<PostagemQuiz> postagemQuiz = new ArrayList<>();
	
	

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getCelular() {
		return celular;
	}

	public void setCelular(long celular) {
		this.celular = celular;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getResponsabilidadePessoal() {
		return responsabilidadePessoal;
	}

	public void setResponsabilidadePessoal(int responsabilidadePessoal) {
		this.responsabilidadePessoal = responsabilidadePessoal;
	}

	public int getMentalidadeCrescimento() {
		return mentalidadeCrescimento;
	}

	public void setMentalidadeCrescimento(int mentalidadeCrescimento) {
		this.mentalidadeCrescimento = mentalidadeCrescimento;
	}

	public int getOrientacaoFuturo() {
		return orientacaoFuturo;
	}

	public void setOrientacaoFuturo(int orientacaoFuturo) {
		this.orientacaoFuturo = orientacaoFuturo;
	}

	public int getPersistencia() {
		return persistencia;
	}

	public void setPersistencia(int persistencia) {
		this.persistencia = persistencia;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public List<Inscricao> getListaInscricao() {
		return listaInscricao;
	}

	public void setListaInscricao(List<Inscricao> listaInscricao) {
		this.listaInscricao = listaInscricao;
	}

	public List<Grupo> getGruposCriados() {
		return gruposCriados;
	}

	public void setGruposCriados(List<Grupo> gruposCriados) {
		this.gruposCriados = gruposCriados;
	}

	public List<PostagemQuiz> getPostagemQuiz() {
		return postagemQuiz;
	}

	public void setPostagemQuiz(List<PostagemQuiz> postagemQuiz) {
		this.postagemQuiz = postagemQuiz;
	}

}
