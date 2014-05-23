package com.sistema.revistas.service;

import java.util.List;
import com.sistema.revistas.dao.RevistaDao;
import com.sistema.revistas.domain.Revista;

public class RevistaService {
	
	private RevistaDao revistaDao;
	
	private static class Loader {
		private static RevistaService revistaServiceInstancia = new RevistaService();
    }
	
	private RevistaService() {
		revistaDao = RevistaDao.getInstanciaDeRevistaDao();
	}
	
	public static RevistaService getInstanciaDeRevistaService() {
		return Loader.revistaServiceInstancia;
	}
	
	public List<Revista> consultaTodasAsRevistas() {
		return revistaDao.encontraTodosOsObjetos();
	}
	
	public Boolean excluiRevista(Revista revista) {
		return revistaDao.deletaElemento(revista);
	}
	
	public Revista consultaRevistaPorId(Long id) {
		return revistaDao.encontraObejetoPorId(id);
	}
	
	public Boolean criaRevista(Revista revista) {
		return revistaDao.insereObjeto(revista);
	}
	
	public Boolean atualizaRevista(Revista revista) {
		return revistaDao.atualizaObjeto(revista);
	}
	
}