package com.sistema.revistas.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.sistema.revistas.domain.Revista;

public class MapeadorDeResultSet {
	
	public Revista mapeiaRevista(ResultSet rs) throws SQLException {
		Revista revista = new Revista();

		revista.setId(rs.getLong("CD_REVISTA"));
		revista.setEstaDeletado(rs.getBoolean("BO_ESTA_DELETADO"));
		revista.setNome(rs.getString("NM_NOME"));
		revista.setPrecoDe(rs.getBigDecimal("NR_PRECO_DE"));
		revista.setPrecoPor(rs.getBigDecimal("NR_PRECO_POR"));
		revista.setTemDigital(rs.getBoolean("BO_TEM_DIGITAL"));
		
		return revista;
	}
	
}