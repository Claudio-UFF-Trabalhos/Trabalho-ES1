package com.sistema.revistas.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.domain.Usuario;

public class MapeadorDeResultSet {
	
	public static Usuario mapeiaUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario(rs.getString("NM_NOME"), 
									  rs.getString("NM_SOBRENOME"), 
									  rs.getString("NM_SENHA"), 
									  rs.getBoolean("BO_E_GERENTE"), 
									  rs.getLong("CD_USUARIO"), 
									  rs.getBoolean("BO_ESTA_DELETADO"));
		
		return usuario;
	}
	
	public static Revista mapeiaRevista(ResultSet rs) throws SQLException {
		Revista revista = new Revista(rs.getLong("CD_REVISTA"), 
									  rs.getString("NM_NOME"), 
									  rs.getBoolean("BO_TEM_DIGITAL"), 
									  rs.getBigDecimal("NR_PRECO_DE"), 
									  rs.getBigDecimal("NR_PRECO_POR"), 
									  rs.getBoolean("BO_ESTA_DELETADO"),
									  rs.getString("NM_DESCRICAO"),
									  rs.getString("NM_TIPO"));
		
		return revista;
	}
	
}