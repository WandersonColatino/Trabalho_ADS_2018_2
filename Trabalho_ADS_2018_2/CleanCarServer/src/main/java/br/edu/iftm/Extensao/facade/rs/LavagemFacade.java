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

import br.edu.iftm.Extensao.dao.LavagemDao;
import br.edu.iftm.Extensao.domain.Lavagem;

@Path(value="/lavagem")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class LavagemFacade {
	
	@Inject
	private LavagemDao LavagemDao;
	
	@GET
	public List<Lavagem> getLavagem() {
		List<Lavagem> Lavagems = LavagemDao.getLavagem();
		return Lavagems;
	}
	
	@GET
	@Path("/{codigo}")
	public Lavagem getLavagemId(@PathParam(value="codigo") Integer id) {
		return LavagemDao.getLavagemId(id);
	}
	
	@DELETE
	@Path("/{codigo}")
	public void excluirLavagem(@PathParam(value="codigo") Integer id) {
		LavagemDao.excluirLavagem(id);
	}
	
	@POST
	public void salvarLavagem(Lavagem Lavagem) {
		LavagemDao.inserirLavagem(Lavagem);
	}
	
	@PUT
	public void atualizarLavagem(Lavagem Lavagem) {
		LavagemDao.atualizarLavagem(Lavagem);
	}
	
}





