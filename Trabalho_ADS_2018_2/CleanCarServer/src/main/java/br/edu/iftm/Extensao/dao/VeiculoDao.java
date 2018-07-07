package br.edu.iftm.Extensao.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.Extensao.domain.Veiculo;

public class VeiculoDao {
	
	@PersistenceContext(name="LavaJatoServer-persistence-unit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Veiculo> getVeiculo() {
		Query query = entityManager.createQuery("from Veiculo p");
		return query.getResultList();
	}
	
	public Veiculo getVeiculoId(Integer id) {
		return entityManager.find(Veiculo.class,id);
	}
	
	@Transactional
	public void excluirVeiculo(Integer id) {
		Veiculo p = getVeiculoId(id);
		//Veiculo p1 = new Veiculo();
		//p1.setId(id);
		entityManager.remove(p);
	}
	
	@Transactional
	public void inserirVeiculo(Veiculo Veiculo) {
		//entityManager.getTransaction().begin();
		entityManager.persist(Veiculo);
		//entityManager.getTransaction().commit();
		//entityManager.persist(new Projeto());
	}
	
	@Transactional
	public void atualizarVeiculo(Veiculo Veiculo) {
		Veiculo = entityManager.merge(Veiculo);
		entityManager.persist(Veiculo);
	}

	
}
