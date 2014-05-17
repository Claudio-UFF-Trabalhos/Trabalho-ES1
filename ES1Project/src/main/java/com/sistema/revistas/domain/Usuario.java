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

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getSenha() {
		return senha;
	}

	public Boolean getUsuarioGerente() {
		return usuarioGerente;
	}

	public Boolean getEstaDeletado() {
		return estaDeletado;
	}

}