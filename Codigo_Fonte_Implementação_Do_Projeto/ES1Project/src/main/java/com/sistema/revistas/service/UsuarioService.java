package com.sistema.revistas.service;

import java.util.List;
import com.sistema.revistas.dao.UsuarioDao;
import com.sistema.revistas.domain.Usuario;

public class UsuarioService {
	
	private UsuarioDao usuarioDao;
	
	private static class Loader {
		private static UsuarioService usuarioServiceInstancia = new UsuarioService();
    }
	
	private UsuarioService() {
		usuarioDao = UsuarioDao.getInstanciaDeUsuarioDao();
	}
	
	public static UsuarioService getInstanciaDeUsuarioService() {
		return Loader.usuarioServiceInstancia;
	}
	
	public Usuario autenticaLoginDeUsuario(Usuario usuario) {
		return usuarioDao.autenticaUsuario(usuario);
	}
	
	public Boolean removeUsuario(Usuario usuario) {
		return usuarioDao.deletaElemento(usuario);
	}
	
	public Boolean insereUsuario(Usuario usuario) {
		return usuarioDao.insereObjeto(usuario);
	}
	
	public Boolean atualizaUsuario(Usuario usuario) {
		return usuarioDao.atualizaObjeto(usuario);
	}
	
	public Usuario consultaUsuarioPorId(Long id) {
		return usuarioDao.encontraObejetoPorId(id);
	}
	
	public List<Usuario> consultaTodosOsUsuarios() {
		return usuarioDao.encontraTodosOsObjetos();
	}
	
}