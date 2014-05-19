package com.sistema.revistas.controller.validador;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import com.sistema.revistas.util.ValidadorDeDigitos;

public class ValidadorDeInput {

	public static Boolean validaId(HttpServletRequest request) {
		if (!ValidadorDeDigitos.validaNumero(request.getParameter("id"))) {
			return false;
		}
		
		return true;
	}
	
	public static Boolean validaEdicaoDeRevista(HttpServletRequest request) {
		if (validaCamposObrigatoriosDeRevista(request) && validaCamposBooleano(request.getParameter("temDigital")) 
			&& validaPrecos(request.getParameter("precoDe"), request.getParameter("precoPor")) && 
			validaCamposBooleano(request.getParameter("estaDeletado")) && ValidadorDeDigitos.validaNumero(request.getParameter("id"))) {
			
			return true;
		}
		
		return false;
	}
	
	public static Boolean validaCriacaoDeRevista(HttpServletRequest request) {
		if (validaCamposObrigatoriosDeRevista(request) &&  validaCamposBooleano(request.getParameter("temDigital")) 
			&& validaPrecos(request.getParameter("precoDe"), request.getParameter("precoPor"))) {
		
			return true;
		}
		
		return false;
	}
	
	private static Boolean validaPrecos(String precoDe, String precoPor) {
		try {
			BigDecimal precoDeBigDecimal = new BigDecimal(precoDe);
			BigDecimal precoPorBigDecimal = new BigDecimal(precoPor);
			
			if (precoDeBigDecimal.compareTo(precoPorBigDecimal) < 0) {
				return false;
			}
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static Boolean validaCamposBooleano(String temDigital) {
		if (!Boolean.TRUE.toString().equals(temDigital) && !Boolean.FALSE.toString().equals(temDigital)) {
			return false;
		}
		
		return true;
	}
	
	private static Boolean validaCamposObrigatoriosDeRevista(HttpServletRequest request) {
		return request.getParameter("nome") != null && request.getParameter("tipo") != null && request.getParameter("precoDe") != null && 
			   request.getParameter("precoPor") != null && request.getParameter("temDigital") != null;
	}
	
}