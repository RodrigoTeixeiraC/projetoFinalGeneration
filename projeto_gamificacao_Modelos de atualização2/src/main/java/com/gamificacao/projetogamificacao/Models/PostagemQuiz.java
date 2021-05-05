package com.gamificacao.projetogamificacao.Models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "postagem_quiz")
public class PostagemQuiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPostagem;
	
	@NotNull
	private int fkUsuario;
	@NotNull
	private int fkGrupo;

	@NotNull
	@Size(min = 10, max = 200)
	private String pergunta;
	@NotNull
	@Size(min = 10, max = 200)
	private String respostaCorreta;

	@NotNull
	@Size(min = 10, max = 200)
	private String respostaFalsa;

	@NotNull
	@Size(min = 10, max = 200)
	private String respostaFalsa2;
	
	@NotNull
	private enum mentalidade {

		responsabilidadePessoal, mentalidadeDeCrescimento, orientacaoFutura, persistencia
	};

	@NotNull
	private int pontuacao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	public long getIdPostagem() {
		return idPostagem;
	}

	public void setIdPostagem(long idPostagem) {
		this.idPostagem = idPostagem;
	}

	public int getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public int getFkGrupo() {
		return fkGrupo;
	}

	public void setFkGrupo(int fkGrupo) {
		this.fkGrupo = fkGrupo;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getRespostaCorreta() {
		return respostaCorreta;
	}

	public void setRespostaCorreta(String respostaCorreta) {
		this.respostaCorreta = respostaCorreta;
	}

	public String getRespostaFalsa() {
		return respostaFalsa;
	}

	public void setRespostaFalsa(String respostaFalsa) {
		this.respostaFalsa = respostaFalsa;
	}

	public String getRespostaFalsa2() {
		return respostaFalsa2;
	}

	public void setRespostaFalsa2(String respostaFalsa2) {
		this.respostaFalsa2 = respostaFalsa2;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
