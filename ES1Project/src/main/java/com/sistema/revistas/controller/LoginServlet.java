package com.sistema.revistas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.controller.mensagem.Mensagem;
import com.sistema.revistas.domain.Usuario;
import com.sistema.revistas.service.UsuarioService;

public class LoginServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private UsuarioService usuarioService;
	
	public LoginServlet() {
		super();
		usuarioService = UsuarioService.getInstanciaDeUsuarioService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		renderizaJSP(request, response, "login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = new Usuario.UsuarioBuilder().nome(request.getParameter("nome")).senha(request.getParameter("senha")).build();	
		Usuario usuarioDoBanco = usuarioService.autenticaLoginDeUsuario(usuario);
		
		if (usuarioDoBanco == null) {
			request.getSession().setAttribute("mensagem", Mensagem.loginComErroFactory());
			response.sendRedirect("login?mensagem=true");
		} else {
			//Sessão setada para uma hora
			request.getSession().setAttribute("usuario", usuario);
			request.getSession().setMaxInactiveInterval(30 * 2 * 60); 
			response.sendRedirect("revista/listaRevista");
		}
	}
	
}