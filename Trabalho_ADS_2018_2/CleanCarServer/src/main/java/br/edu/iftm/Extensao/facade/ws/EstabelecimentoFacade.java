package br.edu.iftm.Extensao.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.Extensao.dao.EstabelecimentoDao;
import br.edu.iftm.Extensao.domain.Estabelecimento;

@WebService(serviceName="ws/estabelecimento")
public class EstabelecimentoFacade {
	
	@Inject
	private EstabelecimentoDao estabelecimentoDao;
	
	@WebMethod
	public List<Estabelecimento> getestabelecimentos() {
		List<Estabelecimento> estabelecimentos = estabelecimentoDao.getEstabelecimento();
		
		return estabelecimentos;
	}
	
	@WebMethod
	public Estabelecimento getestabelecimentoId(@WebParam(name="codigoestabelecimento") Integer id) {
		Estabelecimento p = estabelecimentoDao.getEstabelecimentoId(id);
		return p;
	}
	
	@WebMethod
	public void excluirestabelecimento(@WebParam(name="codigoestabelecimento") Integer id) {
		estabelecimentoDao.excluirEstabelecimento(id);
	}
	
	@WebMethod
	public void atualizarestabelecimento(@WebParam(name="estabelecimento") Estabelecimento estabelecimento) {
		estabelecimentoDao.atualizarEstabelecimento(estabelecimento);
	}
	
	@WebMethod
	public void salvarestabelecimento(@WebParam(name="estabelecimento") Estabelecimento estabelecimento) {
		estabelecimentoDao.inserirEstabelecimento(estabelecimento);
	}
	
	

}
