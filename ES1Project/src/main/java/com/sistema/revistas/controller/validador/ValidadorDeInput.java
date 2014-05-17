package com.sistema.revistas.controller.validador;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sistema.revistas.util.ValidadorDeDigitos;

public class ValidadorDeInput {

	public static Boolean validaId(HttpServletRequest request, HttpServletResponse response, String id)	throws IOException {
		if (!ValidadorDeDigitos.validaNumero(id)) {
			request.getSession().setAttribute("mensagemSucesso", null);
			request.getSession().setAttribute("mensagemErro", "Id da revista inválido.");
			
			return false;
		}
		
		return true;
	}
	
	public static Boolean validaEdicaoDeRevista(String id, String estaDeletado, String nome, String precoDe, String precoPor, String temDigital) {
		if (validaSeNulos(nome, precoDe, precoPor, temDigital) && validaCampoBooleano(temDigital) 
			&& validaCamposNumericos(precoDe, precoPor) && validaCampoBooleano(estaDeletado) && ValidadorDeDigitos.validaNumero(id)) {
			return true;
		}
		
		return false;
	}
	
	public static Boolean validaCriacaoDeRevista(String nome, String precoDe, String precoPor, String temDigital) {
		if (validaSeNulos(nome, precoDe, precoPor, temDigital) && validaCampoBooleano(temDigital) 
			&& validaCamposNumericos(precoDe, precoPor)) {
			return true;
		}
		
		return false;
	}
	
	private static Boolean validaCamposNumericos(String precoDe, String precoPor) {
		try {
			new BigDecimal(precoDe);
			new BigDecimal(precoPor);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private static Boolean validaCampoBooleano(String temDigital) {
		if (!Boolean.TRUE.toString().equals(temDigital) && !Boolean.FALSE.toString().equals(temDigital)) {
			return false;
		}
		
		return true;
	}
	
	private static Boolean validaSeNulos(String nome, String precoDe, String precoPor, String temDigital) {
		if (nome == null || precoDe == null || precoPor == null || temDigital == null) {
			return false;
		} 
		
		return true;
	}
	
}