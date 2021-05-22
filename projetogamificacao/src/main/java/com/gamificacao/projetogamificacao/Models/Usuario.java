package com.gamificacao.projetogamificacao.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String usuario;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String sobrenome;
	
	@NotNull
	private String email;
	
	@NotNull
	private long celular;
	
	@NotNull (message = "O campo Data de nascimento de  não pode ser vazio!")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	private int responsabilidadePessoal; //Discutir se será NotNull
	
	private int mentalidadeCrescimento;//Discutir se será NotNull
	
	private int orientacaoFuturo;//Discutir se será NotNull
	
	private int persistencia;//Discutir se será NotNull
	
	@OneToMany(mappedBy = "amigo", cascade = CascadeType.REMOVE)
	private Set<Usuario> clan = new HashSet<Usuario>();
	
	@ManyToOne
	@JsonIgnoreProperties("clan")
	private Usuario amigo;
	
	@OneToMany (mappedBy = "usuarioPrincipal", cascade = CascadeType.REMOVE)
	private List<AprovacaoAmigos> aprovacao = new ArrayList<>();
	
	@OneToMany (mappedBy = "usuarioPedindo", cascade = CascadeType.REMOVE)
	private List<AprovacaoAmigos> meusPedidosAmizade = new ArrayList<>();
	
	@OneToMany(mappedBy = "criador")
	@JsonIgnoreProperties({"criador"})
	private List<Grupo> gruposCriados = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuarioAtividade")
	private List<Atividades> atividadesUsuario = new ArrayList<>();
	
	@NotNull
	private String senha;
	
	private String foto;
	
	@NotNull
	private String avatar; //Substitui icone, verificar com grupo
	
	@OneToMany (mappedBy = "usuarioInscricao", cascade = CascadeType.REMOVE)
	private List<InscricaoGrupo> listaInscricaoUG = new ArrayList<>();
	
	@OneToMany (mappedBy = "usuarioResponsavel", cascade = CascadeType.REMOVE)
	private List<Tarefa> listaTarefas = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long idUsuario) {
		this.id = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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

	public Set<Usuario> getClan() {
		return clan;
	}

	public void setClan(Set<Usuario> clan) {
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

	public List<InscricaoGrupo> getListaInscricaoUG() {
		return listaInscricaoUG;
	}

	public void setListaInscricaoUG(List<InscricaoGrupo> listaInscricaoUG) {
		this.listaInscricaoUG = listaInscricaoUG;
	}

	public Usuario getAmigo() {
		return amigo;
	}

	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}

	public List<Grupo> getGruposCriados() {
		return gruposCriados;
	}

	public void setGruposCriados(List<Grupo> gruposCriados) {
		this.gruposCriados = gruposCriados;
	}

	public List<Atividades> getAtividadesUsuario() {
		return atividadesUsuario;
	}

	public void setAtividadesUsuario(List<Atividades> atividadesUsuario) {
		this.atividadesUsuario = atividadesUsuario;
	}

	public List<AprovacaoAmigos> getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(List<AprovacaoAmigos> aprovacao) {
		this.aprovacao = aprovacao;
	}

	public List<Tarefa> getListaTarefas() {
		return listaTarefas;
	}

	public void setListaTarefas(List<Tarefa> listaTarefas) {
		this.listaTarefas = listaTarefas;
	}

	public List<AprovacaoAmigos> getMeusPedidosAmizade() {
		return meusPedidosAmizade;
	}

	public void setMeusPedidosAmizade(List<AprovacaoAmigos> meusPedidosAmizade) {
		this.meusPedidosAmizade = meusPedidosAmizade;
	}
	
	
	
}
