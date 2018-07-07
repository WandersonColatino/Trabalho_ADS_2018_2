package br.edu.iftm.Extensao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.Extensao.domain.Estabelecimento;

public class EstabelecimentoDao {
	
	@PersistenceContext(name="LavaJatoServer-persistence-unit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Estabelecimento> getEstabelecimento() {
		Query query = entityManager.createQuery("from Estabelecimento p");
		return query.getResultList();
	}
	
	public Estabelecimento getEstabelecimentoId(Integer id) {
		return entityManager.find(Estabelecimento.class,id);
	}
	
	@Transactional
	public void excluirEstabelecimento(Integer id) {
		Estabelecimento p = getEstabelecimentoId(id);
		//Estabelecimento p1 = new Estabelecimento();
		//p1.setId(id);
		entityManager.remove(p);
	}
	
	@Transactional
	public void inserirEstabelecimento(Estabelecimento estabelecimento) {
		//entityManager.getTransaction().begin();
		entityManager.persist(estabelecimento);
		//entityManager.getTransaction().commit();
		//entityManager.persist(new Projeto());
	}
	
	@Transactional
	public void atualizarEstabelecimento(Estabelecimento estabelecimento) {
		estabelecimento = entityManager.merge(estabelecimento);
		entityManager.persist(estabelecimento);
	}

	
}
