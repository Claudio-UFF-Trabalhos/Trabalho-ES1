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
	
	public static class UsuarioBuilder {
		
		private Long id;
		private String nome;
		private String sobrenome;
		private String senha;
		private Boolean usuarioGerente;
		private Boolean estaDeletado = false;
		
		public UsuarioBuilder id(Long val) {
			id = val;
			return this;
		}
		
		public UsuarioBuilder nome(String val) {
			nome = val;
			return this;
		}
		
		public UsuarioBuilder estaDeletado(Boolean val) {
			estaDeletado = val;
			return this;
		}
		
		public UsuarioBuilder sobrenome(String val) {
			sobrenome = val;
			return this;
		}
		
		public UsuarioBuilder senha(String val) {
			senha = val;
			return this;
		}
		
		public UsuarioBuilder usuarioGerente(Boolean val) {
			usuarioGerente = val;
			return this;
		}
		
		public Usuario build() {
			return new Usuario(this);
		}
		
	}
	
	public Usuario(UsuarioBuilder usuarioBuilder) {
		this.id = usuarioBuilder.id;
		this.nome = usuarioBuilder.nome;
		this.sobrenome = usuarioBuilder.sobrenome;
		this.senha = tornaSenhaSegura(usuarioBuilder.senha);
		this.usuarioGerente = usuarioBuilder.usuarioGerente;
		this.estaDeletado = usuarioBuilder.estaDeletado;
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