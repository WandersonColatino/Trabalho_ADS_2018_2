package br.edu.iftm.Extensao.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.Extensao.dao.VeiculoDao;
import br.edu.iftm.Extensao.domain.Veiculo;

@WebService(serviceName="ws/veiculo")
public class VeiculoFacade {
	
	@Inject
	private VeiculoDao VeiculoDao;
	
	@WebMethod
	public List<Veiculo> getVeiculos() {
		List<Veiculo> Veiculos = VeiculoDao.getVeiculo();
		
		return Veiculos;
	}
	
	@WebMethod
	public Veiculo getVeiculoId(@WebParam(name="codigoVeiculo") Integer id) {
		Veiculo p = VeiculoDao.getVeiculoId(id);
		return p;
	}
	
	@WebMethod
	public void excluirVeiculo(@WebParam(name="codigoVeiculo") Integer id) {
		VeiculoDao.excluirVeiculo(id);
	}
	
	@WebMethod
	public void atualizarVeiculo(@WebParam(name="Veiculo") Veiculo Veiculo) {
		VeiculoDao.atualizarVeiculo(Veiculo);
	}
	
	@WebMethod
	public void salvarVeiculo(@WebParam(name="Veiculo") Veiculo Veiculo) {
		VeiculoDao.inserirVeiculo(Veiculo);
	}
	
	

}
