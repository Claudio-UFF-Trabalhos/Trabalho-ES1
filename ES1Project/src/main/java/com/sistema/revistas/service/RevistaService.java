package com.sistema.revistas.service;

import java.util.List;
import com.sistema.revistas.dao.RevistaDao;
import com.sistema.revistas.domain.Revista;

public class RevistaService {
	
	private static class Loader {
		private static RevistaService revistaServiceInstancia = new RevistaService();
    }
	
	private RevistaDao revistaDao;
	
	private RevistaService() {
		revistaDao = RevistaDao.getInstanciaDeRevistaDao();
	}
	
	public static RevistaService getInstanciaDeRevistaService() {
		return Loader.revistaServiceInstancia;
	}
	
	public List<Revista> consultaTodasAsRevistas() {
		return revistaDao.encontraTodosOsObjetos();
	}
	
	public Revista consultaRevistaPorId(Long id) {
		return revistaDao.encontraObejetoPorId(id);
	}
	
	public Boolean criaRevista(Revista revista) {
		return revistaDao.insereObjeto(revista);
	}
	
}