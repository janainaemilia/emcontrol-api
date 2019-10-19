package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import api.model.entity.Equipamento;
import api.model.entity.Usuario;

@Repository
public class EquipamentoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public Equipamento inserir(Equipamento equipamento) throws IOException{
		manager.persist(equipamento);
		return equipamento;
	}
	
	public Equipamento buscar(int id) throws IOException{
		return manager.find(Equipamento.class, id);
	}
	
	public Equipamento atualizar(Equipamento equipamento) throws IOException{
		return manager.merge(equipamento);
	}
	
	public void remover(Equipamento equipamento) throws IOException{
		manager.remove(manager.find(Equipamento.class, equipamento.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> listar() throws IOException{
		return manager.createQuery("select f from Equipamento f ORDER BY f.id DESC").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> listarPorCategoria(String categoria) throws IOException{
		categoria = categoria.toUpperCase();
		
		String jpql = "select f from Equipamento f where UPPER(f.categoria.nome) = :categoria";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("categoria", categoria);
		
		@SuppressWarnings("unchecked")
		List<Equipamento> result = query.getResultList();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> listarNomesEquipamentos() throws IOException{
		
		String jpql = "select f.nome from Equipamento f GROUP BY f.nome";
		
		Query query = manager.createQuery(jpql);
		
		@SuppressWarnings("unchecked")
		List<String> result = query.getResultList();
		
		return result;
	}
}