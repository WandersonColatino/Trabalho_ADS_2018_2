package br.edu.iftm.Extensao.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.Extensao.dao.LavagemDao;
import br.edu.iftm.Extensao.domain.Lavagem;

@WebService(serviceName="ws/lavagem")
public class LavagemFacade {
	
	@Inject
	private LavagemDao LavagemDao;
	
	@WebMethod
	public List<Lavagem> getLavagems() {
		List<Lavagem> Lavagems = LavagemDao.getLavagem();
		
		return Lavagems;
	}
	
	@WebMethod
	public Lavagem getLavagemId(@WebParam(name="codigoLavagem") Integer id) {
		Lavagem p = LavagemDao.getLavagemId(id);
		return p;
	}
	
	@WebMethod
	public void excluirLavagem(@WebParam(name="codigoLavagem") Integer id) {
		LavagemDao.excluirLavagem(id);
	}
	
	@WebMethod
	public void atualizarLavagem(@WebParam(name="Lavagem") Lavagem Lavagem) {
		LavagemDao.atualizarLavagem(Lavagem);
	}
	
	@WebMethod
	public void salvarLavagem(@WebParam(name="Lavagem") Lavagem Lavagem) {
		LavagemDao.inserirLavagem(Lavagem);
	}
	
	

}
