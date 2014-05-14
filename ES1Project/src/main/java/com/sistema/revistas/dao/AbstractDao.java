package com.sistema.revistas.dao;

import java.util.List;

import com.sistema.revistas.dao.datasource.DataSource;

public abstract class AbstractDao<T> {

	protected DataSource dataSource;
	protected static final String CAMINHO_DO_ARQUIVO = "src/main/resources/config.properties";
	
	public abstract Boolean insereObjeto(T objeto);
	public abstract void atualizaObjeto();
	public abstract void deletaElemento();
	public abstract List<T> encontraTodosOsObjetos();
	public abstract T encontraObejetoPorId(Long id);
	
}