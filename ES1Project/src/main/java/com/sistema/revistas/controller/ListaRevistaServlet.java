package com.sistema.revistas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.service.RevistaService;

public class ListaRevistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public ListaRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		criaMensagem(request);
		
		List<Revista> revistas = revistaService.consultaTodasAsRevistas();		
		request.getSession().setAttribute("revistas", revistas);
		
		response.sendRedirect("lista_revista.jsp");
	}
	
	private void criaMensagem(HttpServletRequest request) {
		String mensagem = request.getParameter("success");
		
		if (mensagem != null && Boolean.TRUE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemSucesso", "Revista foi deletada com sucesso.");
			request.getSession().setAttribute("mensagemErro", null);
		} else if (mensagem != null && Boolean.FALSE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemErro", "Erro ao deletar a revista.");
			request.getSession().setAttribute("mensagemSucesso", null);
		} else {
			request.getSession().setAttribute("mensagemSucesso", null);
			request.getSession().setAttribute("mensagemErro", null);
		}
	}

}