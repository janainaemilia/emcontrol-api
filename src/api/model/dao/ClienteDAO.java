package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import api.model.entity.Cliente;
import api.model.entity.Usuario;

@Repository
public class ClienteDAO {

	@PersistenceContext
	EntityManager manager;
	
	public Cliente inserir(Cliente cliente) throws IOException{
		manager.persist(cliente);
		return cliente;
	}
	
	public Cliente buscar(int id) throws IOException{
		return manager.find(Cliente.class, id);
	}
	
	public Cliente buscar(String email) {
		String jpql = "select c from Cliente c where c.email = :email";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("email", email);
		
		@SuppressWarnings("unchecked")
		List<Cliente> result = query.getResultList();
		
		System.out.println(result);
		if(result.size() != 0)
			return result.get(0);
		
		return null;
	}
	
	public Cliente buscar(Usuario usuario) {
		String jpql = "select c from Cliente c where c.usuario = :usuario";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("usuario", usuario);
		
		@SuppressWarnings("unchecked")
		List<Cliente> result = query.getResultList();
		
		System.out.println(result);
		if(result.size() != 0)
			return result.get(0);
		
		return null;
	}
	
	public void atualizar(Cliente cliente) throws IOException{
		manager.merge(cliente);
	}
	
	public void remover(Cliente cliente) throws IOException{
		manager.remove(manager.find(Cliente.class, cliente.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() throws IOException{
		return manager.createQuery("select f from Cliente f").getResultList();
	}
}