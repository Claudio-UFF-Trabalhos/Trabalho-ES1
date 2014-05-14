package com.sistema.revistas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.sistema.revistas.domain.Revista;
import com.sistema.revistas.dao.datasource.DataSource;
import com.sistema.revistas.dao.mapper.MapeadorDeResultSet;
import com.sistema.revistas.util.CarregadorDePropriedades;

public class RevistaDao extends AbstractDao<Revista> {
	
	private static class Loader {
		private static RevistaDao revistaDaoInstancia = new RevistaDao();
    }
		
	private RevistaDao() {
		Properties propriedades = CarregadorDePropriedades.carregaPropriedades(CAMINHO_DO_ARQUIVO);
		
		dataSource = new DataSource(propriedades.getProperty("dataSource.url"),
								    propriedades.getProperty("dataSource.username"),
								    propriedades.getProperty("dataSource.password"),
									propriedades.getProperty("dataSource.driver"));
	}
	
	public static RevistaDao getInstanciaDeRevistaDao() {
		return Loader.revistaDaoInstancia;
	}

	@Override
	public Boolean insereObjeto(Revista revista) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			
			String sql = "INSERT INTO REVISTA (CD_REVISTA, NM_NOME, BO_TEM_DIGITAL, NR_PRECO_DE, NR_PRECO_POR, " + 
			"BO_ESTA_DELETADO) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, revista.getId());
			statement.setString(2, revista.getNome());
			statement.setBoolean(3, revista.getTemDigital());
			statement.setBigDecimal(4, revista.getPrecoDe());
			statement.setBigDecimal(5, revista.getPrecoPor());
			statement.setBoolean(6, revista.getEstaDeletado());
			statement.execute();
			
			fechaRecursos(connection, statement);
			return true;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void atualizaObjeto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletaElemento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Revista> encontraTodosOsObjetos() {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
	
			String sql = "SELECT * FROM REVISTA";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			ArrayList<Revista> ListaDerevistas = new ArrayList<Revista>();
			while (rs.next()) {
				ListaDerevistas.add(new MapeadorDeResultSet().mapeiaRevista(rs));
			}
			
			fechaRecursos(connection, statement, rs);
			return ListaDerevistas;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<Revista>();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Revista>();
		}
	}

	@Override
	public Revista encontraObejetoPorId(Long id) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
	
			String sql = "SELECT * FROM REVISTA WHERE CD_REVISTA = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			Revista revista = new MapeadorDeResultSet().mapeiaRevista(rs);
			fechaRecursos(connection, statement, rs);
			
			return revista;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void fechaRecursos(Connection connection, Statement statement) throws SQLException {
		fechaRecursos(connection, statement, null);
	}

	private void fechaRecursos(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
		if(resultSet != null) {
			resultSet.close();
		}
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
 
}