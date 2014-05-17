package com.sistema.revistas.util;

public class ValidadorDeDigitos {
	
	private static final String QUANTITY_REGEX = "^(0|[1-9][0-9]*)$";
	
	public static boolean validaNumero(String input) {		
		return input != null && input.matches(QUANTITY_REGEX);
	}
	
}