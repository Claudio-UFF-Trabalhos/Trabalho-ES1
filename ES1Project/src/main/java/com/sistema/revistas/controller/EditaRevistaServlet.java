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

public class EditaRevistaServlet extends BaseServlet {
	
	private static final long serialVersionUID = 1L;
	private RevistaService revistaService;

    public EditaRevistaServlet() {
        super();        
    	revistaService = RevistaService.getInstanciaDeRevistaService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if (!ValidadorDeInput.validaId(request)) {
			request.getSession().setAttribute("revista", null);
		} else {
			Long id = new Long(request.getParameter("id"));
			Revista revista = revistaService.consultaRevistaPorId(id);
			request.getSession().setAttribute("revista", revista);
		}

		renderizaJSP(request, response, "editar_revista.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ValidadorDeInput.validaEdicaoDeRevista(request)) {
			Revista revista = new Revista.RevistaBuilder().id(new Long(request.getParameter("id"))).nome(request.getParameter("nome")).
					temDigital(new Boolean(request.getParameter("temDigital"))).precoDe(new BigDecimal(request.getParameter("precoDe"))).
					precoPor(new BigDecimal(request.getParameter("precoPor"))).estaDeletado(new Boolean(request.getParameter("estaDeletado"))).
					descricao(request.getParameter("descricao")).tema(request.getParameter("tema")).build();
			
			editaRevista(request, revista);
		}
		
		response.sendRedirect("editaRevista?id=" + request.getParameter("id")+ "&mensagem=true");		
	}

	private void editaRevista(HttpServletRequest request, Revista revista) {
		if (revistaService.atualizaRevista(revista)) {
			request.getSession().setAttribute("mensagem", Mensagem.editarComSucessoFactory());
		} else {
			request.getSession().setAttribute("mensagem", Mensagem.editarComErroFactory());
		}
	}

}