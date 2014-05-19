package com.sistema.revistas.controller.mensagem;

public class Mensagem {

	private String tipo;
	private String texto;
	
	private Mensagem(String tipo, String texto) {
		this.tipo = tipo;
		this.texto = texto;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public static Mensagem cadastrarComSucessoFactory() {
		return new Mensagem("mensagemSucesso", "Revista cadastrada com sucesso.");
	}
	
	public static Mensagem cadastrarComErroFactory() {
		return new Mensagem("mensagemErro", "Erro ao cadastrar revista.");
	}
	
	public static Mensagem editarComSucessoFactory() {
		return new Mensagem("mensagemSucesso", "Revista editada com sucesso.");
	}
	
	public static Mensagem deletarComErroFactory() {
		return new Mensagem("mensagemErro", "Erro ao excluir revista.");
	}
	
	public static Mensagem deletarComSucessoFactory() {
		return new Mensagem("mensagemSucesso", "Revista excluída com sucesso.");
	}
	
	public static Mensagem editarComErroFactory() {
		return new Mensagem("mensagemErro", "Erro ao editar revista.");
	}
	
	public static Mensagem loginComErroFactory() {
		return new Mensagem("mensagemErro", "Senha ou nome de usuário inválidos.");
	}
	
	public static Mensagem erroIdInvalidoFactory() {
		return new Mensagem("mensagemErro", "Id de revista inválido.");
	}

}