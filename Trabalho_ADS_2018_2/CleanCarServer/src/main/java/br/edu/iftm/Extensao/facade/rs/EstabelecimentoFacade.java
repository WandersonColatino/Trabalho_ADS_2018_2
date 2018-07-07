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

import br.edu.iftm.Extensao.dao.EstabelecimentoDao;
import br.edu.iftm.Extensao.domain.Estabelecimento;

@Path(value="/estabelecimento")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class EstabelecimentoFacade {
	
	@Inject
	private EstabelecimentoDao estabelecimentoDao;
	
	@GET
	public List<Estabelecimento> getEstabelecimento() {
		List<Estabelecimento> estabelecimentos = estabelecimentoDao.getEstabelecimento();
		return estabelecimentos;
	}
	
	@GET
	@Path("/{codigo}")
	public Estabelecimento getEstabelecimentoId(@PathParam(value="codigo") Integer id) {
		return estabelecimentoDao.getEstabelecimentoId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirEstabelecimento(@PathParam(value="codigo") Integer id) {
		estabelecimentoDao.excluirEstabelecimento(id);
	}
	
	@POST
	public void salvarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoDao.inserirEstabelecimento(estabelecimento);
	}
	
	@PUT
	public void atualizarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimentoDao.atualizarEstabelecimento(estabelecimento);
	}
	
}





