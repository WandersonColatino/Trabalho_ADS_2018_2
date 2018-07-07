package br.edu.iftm.Extensao.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.iftm.Extensao.dao.VeiculoDao;
import br.edu.iftm.Extensao.domain.Veiculo;

@Path(value="/veiculo")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class VeiculoFacade {
	
	@Inject
	private VeiculoDao VeiculoDao;
	
	@GET
	public List<Veiculo> getVeiculo() {
		List<Veiculo> Veiculos = VeiculoDao.getVeiculo();
		return Veiculos;
	}
	
	@GET
	@Path("/{codigo}")
	public Veiculo getVeiculoId(@PathParam(value="codigo") Integer id) {
		return VeiculoDao.getVeiculoId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirVeiculo(@PathParam(value="codigo") Integer id) {
		VeiculoDao.excluirVeiculo(id);
	}
	
	@POST
	public void salvarVeiculo(Veiculo Veiculo) {
		VeiculoDao.inserirVeiculo(Veiculo);
	}
	
	@PUT
	public void atualizarVeiculo(Veiculo Veiculo) {
		VeiculoDao.atualizarVeiculo(Veiculo);
	}
	
}





