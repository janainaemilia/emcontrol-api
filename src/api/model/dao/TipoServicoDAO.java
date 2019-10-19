package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import api.model.entity.TipoServico;

@Repository
public class TipoServicoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public TipoServico inserir(TipoServico tipoServico) throws IOException{
		manager.persist(tipoServico);
		return tipoServico;
	}
	
	public TipoServico buscar(int id) throws IOException{
		return manager.find(TipoServico.class, id);
	}
	
	public void atualizar(TipoServico tipoServico) throws IOException{
		manager.merge(tipoServico);
	}
	
	public void remover(TipoServico tipoServico) throws IOException{
		manager.remove(manager.find(TipoServico.class, tipoServico.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoServico> listar() throws IOException{
		return manager.createQuery("select f from TipoServico f").getResultList();
	}
}