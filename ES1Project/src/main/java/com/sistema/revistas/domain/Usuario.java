package com.sistema.revistas.domain;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Usuario {
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String senha;
	private Boolean usuarioGerente;
	private Boolean estaDeletado;
	
	public Usuario(String nome, String senha) {
		this.nome = nome;
		this.senha = tornaSenhaSegura(senha);
	}
	
	public Usuario(String nome, String sobrenome, String senha, Boolean usuarioGerente, Long id, Boolean estaDeletado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.senha = tornaSenhaSegura(senha);
		this.usuarioGerente = usuarioGerente;
		this.id = id;
		this.estaDeletado = estaDeletado;
	}
	
	private String tornaSenhaSegura(String senhaParaHash){
		String salt = "sistemarevista";
        String senhaGerada = null;
        
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt.getBytes());
            
            byte[] bytes = md.digest(senhaParaHash.getBytes());
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            
            senhaGerada = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) {
        	e.printStackTrace();
        }
        
        return senhaGerada;
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