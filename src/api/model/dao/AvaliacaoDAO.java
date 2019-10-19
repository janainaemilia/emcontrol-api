package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import api.model.entity.Avaliacao;

@Repository
public class AvaliacaoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public Avaliacao inserir(Avaliacao avaliacao) throws IOException{
		manager.persist(avaliacao);
		return avaliacao;
	}
	
	public Avaliacao buscar(int id) throws IOException{
		return manager.find(Avaliacao.class, id);
	}
	
	public void atualizar(Avaliacao avaliacao) throws IOException{
		manager.merge(avaliacao);
	}
	
	public void remover(Avaliacao avaliacao) throws IOException{
		manager.remove(manager.find(Avaliacao.class, avaliacao.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> listar() throws IOException{
		return manager.createQuery("select f from Avaliacao f").getResultList();
	}
}