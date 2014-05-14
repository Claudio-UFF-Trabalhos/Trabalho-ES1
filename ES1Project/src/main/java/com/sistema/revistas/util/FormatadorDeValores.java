package com.sistema.revistas.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatadorDeValores {
	
	public static String formataNumero(BigDecimal value) {
		Locale local = new Locale("pt", "BR");
		DecimalFormat df = new DecimalFormat("#,##0.00", new DecimalFormatSymbols(local));
				
		return "R$ " + df.format(value);
	}
	
}