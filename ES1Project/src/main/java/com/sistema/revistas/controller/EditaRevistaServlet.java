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

public class EditaRevistaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public EditaRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametroId = request.getParameter("id");	
		
		if (!ValidadorDeInput.validaId(request, response, parametroId)) {
			response.sendRedirect("editar_revista.jsp");
			request.getSession().setAttribute("revista", null);
			return;
		}
		
		criaMensagem(request);	
		
		Long id = new Long(parametroId);
		Revista revista = revistaService.consultaRevistaPorId(id);
		request.getSession().setAttribute("revista", revista);
		
		response.sendRedirect("editar_revista.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String precoDe = request.getParameter("precoDe");
		String precoPor = request.getParameter("precoPor");
		String temDigital = request.getParameter("temDigital");
		String estaDeletado = request.getParameter("estaDeletado");
		
		if (ValidadorDeInput.validaEdicaoDeRevista(id, estaDeletado, nome, precoDe, precoPor, temDigital)) {
			Revista revista = new Revista(new Long(id), 
										  nome, 
										  new Boolean(temDigital), 
										  new BigDecimal(precoDe), 
										  new BigDecimal(precoPor), 
										  new Boolean(estaDeletado));
			
			if (revistaService.atualizaRevista(revista)) {
				response.sendRedirect("editaRevista?id=" + revista.getId() + "&success=true");
				return;
			}
			
			response.sendRedirect("editaRevista?id=" + revista.getId() + "&success=false");
		}
		
		response.sendRedirect("editaRevista?id=" + id + "&success=false");		
	}
	
	private void criaMensagem(HttpServletRequest request) {
		String mensagem = request.getParameter("success");
		
		if (mensagem != null && Boolean.TRUE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemSucesso", "Revista editada com sucesso.");
			request.getSession().setAttribute("mensagemErro", null);
		} else if (mensagem != null && Boolean.FALSE.toString().equals(mensagem)) {
			request.getSession().setAttribute("mensagemErro", "Erro ao editar revista.");
			request.getSession().setAttribute("mensagemSucesso", null);
		} else {
			request.getSession().setAttribute("mensagemSucesso", null);
			request.getSession().setAttribute("mensagemErro", null);
		}
	}

}