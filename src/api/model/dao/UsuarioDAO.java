package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import api.model.entity.Usuario;

@Repository
public class UsuarioDAO {

	@PersistenceContext
	EntityManager manager;
	
	public Usuario login(Usuario user) {
		String jpql = "select u from Usuario u where u.login = :login";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("login", user.getLogin());
		
		@SuppressWarnings("unchecked")
		List<Usuario> result = query.getResultList();
			
		if(result.size() >= 1) {
			if(result.get(0).getSenha().equals(user.getSenha()))
				return result.get(0);
		}		
		
		return null;
	}
	
	public Usuario inserir(Usuario usuario) throws IOException{
		manager.persist(usuario);
		return usuario;
	}
	
	public Usuario buscar(int id) throws IOException{
		return manager.find(Usuario.class, id);
	}
	
	public Usuario buscar(Usuario user) {
		String jpql = "select u from Usuario u where u.login = :login";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("login", user.getLogin());
		
		@SuppressWarnings("unchecked")
		List<Usuario> result = query.getResultList();
			
		if(result.size() != 1)			
			return result.get(0);	
		
		return null;
	}
	
	public Usuario atualizar(Usuario usuario) throws IOException{
		manager.merge(usuario);
		return usuario;
	}
	
	public void remover(Usuario usuario) throws IOException{
		manager.remove(manager.find(Usuario.class, usuario.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() throws IOException{
		return manager.createQuery("select u from Usuario u").getResultList();
	}
}