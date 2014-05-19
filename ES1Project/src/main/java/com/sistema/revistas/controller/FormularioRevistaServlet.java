package com.sistema.revistas.controller;

import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.controller.mensagem.Mensagem;
import com.sistema.revistas.controller.validador.ValidadorDeInput;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.service.RevistaService;

public class FormularioRevistaServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public FormularioRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		renderizaJSP(request, response, "formulario_revista.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ValidadorDeInput.validaCriacaoDeRevista(request)) {
			Revista revista = new Revista.RevistaBuilder().nome(request.getParameter("nome")).
					temDigital(new Boolean(request.getParameter("temDigital"))).precoPor(new BigDecimal(request.getParameter("precoPor"))).
					precoDe(new BigDecimal(request.getParameter("precoDe"))).descricao(request.getParameter("descricao")).
					tipo(request.getParameter("tipo")).build();
			
			cadastraRevista(request, revista);
		} 
				
		response.sendRedirect("formularioRevista?mensagem=true");
	}

	private void cadastraRevista(HttpServletRequest request, Revista revista) {
		if (revistaService.criaRevista(revista)) {
			request.getSession().setAttribute("mensagem", Mensagem.cadastrarComSucessoFactory());
		} else {
			request.getSession().setAttribute("mensagem", Mensagem.cadastrarComErroFactory());
		}
	}

}