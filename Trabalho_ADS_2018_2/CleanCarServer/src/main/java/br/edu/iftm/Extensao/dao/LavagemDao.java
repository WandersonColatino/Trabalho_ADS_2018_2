package br.edu.iftm.Extensao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.Extensao.domain.Lavagem;

public class LavagemDao {
	
	@PersistenceContext(name="LavaJatoServer-persistence-unit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Lavagem> getLavagem() {
		Query query = entityManager.createQuery("from Lavagem p");
		return query.getResultList();
	}
	
	public Lavagem getLavagemId(Integer id) {
		return entityManager.find(Lavagem.class,id);
	}
	
	@Transactional
	public void excluirLavagem(Integer id) {
		Lavagem p = getLavagemId(id);
		//Lavagem p1 = new Lavagem();
		//p1.setId(id);
		entityManager.remove(p);
	}
	
	@Transactional
	public void inserirLavagem(Lavagem Lavagem) {
		//entityManager.getTransaction().begin();
		entityManager.persist(Lavagem);
		//entityManager.getTransaction().commit();
		//entityManager.persist(new Projeto());
	}
	
	@Transactional
	public void atualizarLavagem(Lavagem Lavagem) {
		Lavagem = entityManager.merge(Lavagem);
		entityManager.persist(Lavagem);
	}

	
}
