package com.sistema.revistas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.controller.mensagem.Mensagem;
import com.sistema.revistas.controller.validador.ValidadorDeInput;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.service.RevistaService;

public class DeletaRevistaServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public DeletaRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if (!ValidadorDeInput.validaId(request)) {
			request.setAttribute("mensagem", Mensagem.erroIdInvalidoFactory());
		} else {
			Long id = new Long(request.getParameter("id"));
			Revista revista = revistaService.consultaRevistaPorId(id);
			excluiRevista(request, revista);
		}
		
		response.sendRedirect("listaRevista?mensagem=true");
	}

	private void excluiRevista(HttpServletRequest request, Revista revista) {
		if (revista != null && revistaService.excluiRevista(revista)) {
			request.getSession().setAttribute("mensagem", Mensagem.deletarComSucessoFactory());
		} else {
			request.getSession().setAttribute("mensagem", Mensagem.deletarComErroFactory());
		}
	}

}