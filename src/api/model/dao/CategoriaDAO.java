package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import api.model.entity.Categoria;

@Repository
public class CategoriaDAO {

	@PersistenceContext
	EntityManager manager;
	
	public Categoria inserir(Categoria categoria) throws IOException{
		manager.persist(categoria);
		return categoria;
	}
	
	public Categoria buscar(int id) throws IOException{
		return manager.find(Categoria.class, id);
	}
	
	public Categoria atualizar(Categoria categoria) throws IOException{
		manager.merge(categoria);
		return categoria;
	}
	
	public void remover(Categoria categoria) throws IOException{
		manager.remove(manager.find(Categoria.class, categoria.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategoria() throws IOException{
		return manager.createQuery("select f from Categoria f where f.categoriaPai = null").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarSubcategoria() throws IOException{
		return manager.createQuery("select f from Categoria f where f.categoriaPai != null").getResultList();
	}
}