package com.sistema.revistas.domain;

public class Usuario {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String senha;
	private Boolean usuarioGerente;
	private Boolean estaDeletado;
	
	public Usuario(String nome, String sobrenome, String senha, Boolean usuarioGerente) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = senha;
		this.usuarioGerente = usuarioGerente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getUsuarioGerente() {
		return usuarioGerente;
	}

	public void setUsuarioGerente(Boolean usuarioGerente) {
		this.usuarioGerente = usuarioGerente;
	}

	public Boolean getEstaDeletado() {
		return estaDeletado;
	}

	public void setEstaDeletado(Boolean estaDeletado) {
		this.estaDeletado = estaDeletado;
	}

}