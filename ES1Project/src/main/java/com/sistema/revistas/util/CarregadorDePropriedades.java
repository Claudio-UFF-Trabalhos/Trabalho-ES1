package com.sistema.revistas.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CarregadorDePropriedades {
	
	public static Properties carregaPropriedades(String caminhoDoArquivo) {
		Properties propriedades = null;
		InputStream input = null;
	 
		try {
			propriedades = new Properties();
			input = new FileInputStream(caminhoDoArquivo);
			propriedades.load(input);
	 
			return propriedades;
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return propriedades;
	}
	
}