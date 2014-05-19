package com.sistema.revistas.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.domain.Usuario;

public class MapeadorDeResultSet {
	
	public static Usuario mapeiaUsuario(ResultSet rs) throws SQLException {
		Usuario usuario = new Usuario.UsuarioBuilder().nome(rs.getString("NM_NOME")).sobrenome(rs.getString("NM_SOBRENOME")).
				senha(rs.getString("NM_SENHA")).usuarioGerente(rs.getBoolean("BO_E_GERENTE")).id(rs.getLong("CD_USUARIO")).
				estaDeletado(rs.getBoolean("BO_ESTA_DELETADO")).build();
		
		return usuario;
	}
	
	public static Revista mapeiaRevista(ResultSet rs) throws SQLException {
		Revista revista = new Revista.RevistaBuilder().id(rs.getLong("CD_REVISTA")).nome(rs.getString("NM_NOME")).
				temDigital(rs.getBoolean("BO_TEM_DIGITAL")).precoDe(rs.getBigDecimal("NR_PRECO_DE")).
				precoPor(rs.getBigDecimal("NR_PRECO_POR")).estaDeletado(rs.getBoolean("BO_ESTA_DELETADO")).descricao(rs.getString("NM_DESCRICAO")).
				tipo(rs.getString("NM_TIPO")).build();
		
		return revista;
	}
	
}