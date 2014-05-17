package com.sistema.revistas.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.revistas.controller.validador.ValidadorDeInput;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.service.RevistaService;

public class FormularioRevistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public FormularioRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criaMensagem(request);

		response.sendRedirect("formulario_revista.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String precoDe = request.getParameter("precoDe");
		String precoPor = request.getParameter("precoPor");
		String temDigital = request.getParameter("temDigital");
		
		if (ValidadorDeInput.validaCriacaoDeRevista(nome, precoDe, precoPor, temDigital)) {
			Revista revista = new Revista(nome, new Boolean(temDigital), new BigDecimal(precoDe), new BigDecimal(precoPor));
			
			if (revistaService.criaRevista(revista)) {
				response.sendRedirect("formularioRevista?success=true");
				return;
			} 
		} 
		
		response.sendRedirect("formularioRevista?success=false");
	}
	
	private void criaMensagem(HttpServletRequest request) {
		String mensagem = request.getParameter("success");
		
		if (mensagem != null && Boolean.TRUE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemSucesso", "Revista cadastrada com sucesso.");
			request.getSession().setAttribute("mensagemErro", null);
		} else if (mensagem != null && Boolean.FALSE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemErro", "Erro ao cadastrar revista.");
			request.getSession().setAttribute("mensagemSucesso", null);
		} else {
			request.getSession().setAttribute("mensagemSucesso", null);
			request.getSession().setAttribute("mensagemErro", null);
		}
	}

}