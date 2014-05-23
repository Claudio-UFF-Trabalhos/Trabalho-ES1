package com.sistema.revistas.controller.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sistema.revistas.domain.Usuario;

public class LoginFilter implements Filter {

    public LoginFilter() {
        super();        
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		Usuario usuario = (Usuario) httpRequest.getSession().getAttribute("usuario");
		
		if (usuario == null) {
			httpResponse.sendRedirect("http://localhost:8080/ES1Project/login");
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}