package com.sistema.revistas.controller;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void renderizaJSP(HttpServletRequest request, HttpServletResponse response, String urlPagina) throws IOException {
		if (request.getParameter("mensagem") == null) {
			request.getSession().setAttribute("mensagem", null);
		}
		
		response.sendRedirect(urlPagina);
	}
	
}