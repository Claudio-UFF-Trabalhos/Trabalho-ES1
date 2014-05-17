package com.sistema.revistas.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.sistema.revistas.domain.Revista;

public class MapeadorDeResultSet {
	
	public static Revista mapeiaRevista(ResultSet rs) throws SQLException {
		Revista revista = new Revista(rs.getLong("CD_REVISTA"), 
									  rs.getString("NM_NOME"), 
									  rs.getBoolean("BO_TEM_DIGITAL"), 
									  rs.getBigDecimal("NR_PRECO_DE"), rs.getBigDecimal("NR_PRECO_POR"), 
									  rs.getBoolean("BO_ESTA_DELETADO"));
		
		return revista;
	}
	
}