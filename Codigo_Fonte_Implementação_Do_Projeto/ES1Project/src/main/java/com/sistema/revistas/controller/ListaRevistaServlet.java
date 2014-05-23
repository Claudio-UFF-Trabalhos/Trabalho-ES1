package com.sistema.revistas.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.service.RevistaService;

public class ListaRevistaServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public ListaRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		List<Revista> revistas = revistaService.consultaTodasAsRevistas();		
		request.getSession().setAttribute("revistas", revistas);

		renderizaJSP(request, response, "lista_revista.jsp");	
	}

}