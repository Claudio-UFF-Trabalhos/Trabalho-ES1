package com.sistema.revistas.dao.datasource;

public class DataSource {

	private String url;
	private String username;
	private String password;
	private String driverClass;
	
	public DataSource(String url, String username, String password, String driverClass) {
		this.url = url;
		this.username = username;
		this.password = password;
		this.driverClass = driverClass;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDriverClass() {
		return driverClass;
	}

}