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
import com.sistema.revistas.domain.Usuario;
import com.sistema.revistas.dao.datasource.DataSource;
import com.sistema.revistas.dao.mapper.MapeadorDeResultSet;
import com.sistema.revistas.util.CarregadorDePropriedades;

public class UsuarioDao extends GenericDao<Usuario> {
	
	private static class Loader {
		private static UsuarioDao usuarioDaoInstancia = new UsuarioDao();
    }
		
	private UsuarioDao() {
		Properties propriedades = CarregadorDePropriedades.carregaPropriedades(CAMINHO_DO_ARQUIVO);
		
		dataSource = new DataSource(propriedades.getProperty("dataSource.url"),
								    propriedades.getProperty("dataSource.username"),
								    propriedades.getProperty("dataSource.password"),
									propriedades.getProperty("dataSource.driver"));
	}
	
	public static UsuarioDao getInstanciaDeUsuarioDao() {
		return Loader.usuarioDaoInstancia;
	}

	public Usuario autenticaUsuario(Usuario usuario) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
	
			String sql = "SELECT * FROM USUARIO WHERE NM_NOME = ? AND NM_SENHA = ? AND BO_E_GERENTE = 1 AND BO_ESTA_DELETADO = 0";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
	
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				Usuario usuarioDoBanco = MapeadorDeResultSet.mapeiaUsuario(rs);
				fechaRecursos(connection, statement, rs);
								
				return usuarioDoBanco;
			}
			
			fechaRecursos(connection, statement, rs);
			return null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public Boolean insereObjeto(Usuario usuario) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			
			String sql = "INSERT INTO USUARIO (NM_NOME, NM_SOBRENOME, NM_SENHA, " + 
			"BO_ESTA_DELETADO, BO_E_GERENTE) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getSenha());
			statement.setBoolean(4, usuario.getEstaDeletado());
			statement.setBoolean(5, usuario.getUsuarioGerente());

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
	public Boolean atualizaObjeto(Usuario usuario) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			
			String sql = "UPDATE USUARIO SET NM_NOME = ?, NM_SOBRENOME = ?, NM_SENHA = ?, BO_ESTA_DELETADO = ?, BO_E_GERENTE = ?"
					+ " WHERE CD_USUARIO = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSobrenome());
			statement.setString(3, usuario.getSenha());
			statement.setBoolean(4, usuario.getEstaDeletado());
			statement.setBoolean(5, usuario.getUsuarioGerente());	
			statement.setLong(6, usuario.getId());
			
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
	public Boolean deletaElemento(Usuario usuario) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
			
			String sql = "UPDATE USUARIO SET BO_ESTA_DELETADO = ? WHERE CD_USUARIO = ?"; 
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setLong(2, usuario.getId());
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
	public List<Usuario> encontraTodosOsObjetos() {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
	
			String sql = "SELECT * FROM USUARIO WHERE BO_ESTA_DELETADO = 0";
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			ArrayList<Usuario> ListaDeUsuarios = new ArrayList<Usuario>();
			while (rs.next()) {
				ListaDeUsuarios.add(MapeadorDeResultSet.mapeiaUsuario(rs));
			}
			
			fechaRecursos(connection, statement, rs);
			return ListaDeUsuarios;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<Usuario>();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Usuario>();
		}
	}

	@Override
	public Usuario encontraObejetoPorId(Long id) {
		try {
			Class.forName(dataSource.getDriverClass());
			Connection connection = DriverManager.getConnection(dataSource.getUrl(), dataSource.getUsername(), dataSource.getPassword());
	
			String sql = "SELECT * FROM USUARIO WHERE CD_USUARIO = ? AND BO_ESTA_DELETADO = 0";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			if (rs.next()) {
				Usuario usuario = MapeadorDeResultSet.mapeiaUsuario(rs);
				fechaRecursos(connection, statement, rs);
				
				return usuario;
			}
			
			fechaRecursos(connection, statement, rs);
			return null;
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