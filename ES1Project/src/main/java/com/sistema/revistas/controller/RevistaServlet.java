package com.sistema.revistas.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.service.RevistaService;

public class RevistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public RevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("formulario_revista.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}