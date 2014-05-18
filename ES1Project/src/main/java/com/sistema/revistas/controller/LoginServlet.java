package com.sistema.revistas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.domain.Usuario;
import com.sistema.revistas.service.UsuarioService;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	
	public LoginServlet() {
		super();
		usuarioService = UsuarioService.getInstanciaDeUsuarioService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criaMensagem(request);
		
		response.sendRedirect("login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		Usuario usuario = new Usuario(nome, senha);
		
		Usuario usuarioDoBanco = usuarioService.autenticaLoginDeUsuario(usuario);
		if (usuarioDoBanco == null) {
			response.sendRedirect("login?success=false");
			return;
		}
		
		request.getSession().setAttribute("usuario", usuario);
		//setando a sessão para uma hora
		request.getSession().setMaxInactiveInterval(30 * 2 * 60); 
		
		response.sendRedirect("revista/listaRevista");
	}
	
	private void criaMensagem(HttpServletRequest request) {
		String mensagem = request.getParameter("success");

		if (mensagem != null && Boolean.FALSE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemErro", "Login ou senha inválidos.");
		} else {
			request.getSession().setAttribute("mensagemErro", null);
		}
	}
}