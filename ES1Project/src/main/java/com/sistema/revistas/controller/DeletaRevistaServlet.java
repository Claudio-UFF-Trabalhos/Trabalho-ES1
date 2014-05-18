package com.sistema.revistas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.controller.validador.ValidadorDeInput;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.service.RevistaService;

public class DeletaRevistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public DeletaRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroId = request.getParameter("id");	
		
		if (!ValidadorDeInput.validaId(request, response, parametroId)) {
			response.sendRedirect("listaRevista?success=false");
			return;
		}
				
		Long id = new Long(parametroId);
		Revista revista = revistaService.consultaRevistaPorId(id);
		
		if (revista != null && revistaService.excluiRevista(revista)) {
			response.sendRedirect("listaRevista?success=true");
			return;
		}
		
		response.sendRedirect("listaRevista?success=false");
	}

}