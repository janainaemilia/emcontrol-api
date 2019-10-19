package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import api.model.entity.EquipamentoUsuario;
import api.model.entity.Manutencao;
import api.model.entity.Usuario;

@Repository
public class EquipamentoUsuarioDAO {

	@PersistenceContext
	EntityManager manager;
	
	public EquipamentoUsuario inserir(EquipamentoUsuario equipamentoUsuario) throws IOException{
		manager.persist(equipamentoUsuario);
		return equipamentoUsuario;
	}
	
	public EquipamentoUsuario buscar(int id) throws IOException{
		return manager.find(EquipamentoUsuario.class, id);
	}
	
	public EquipamentoUsuario atualizar(EquipamentoUsuario equipamentoUsuario) throws IOException{
		manager.merge(equipamentoUsuario);
		return equipamentoUsuario;
	}
	
	public void remover(EquipamentoUsuario equipamentoUsuario) throws IOException{
		manager.remove(manager.find(EquipamentoUsuario.class, equipamentoUsuario.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<EquipamentoUsuario> listar() throws IOException{
		return manager.createQuery("select f from EquipamentoUsuario f").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<EquipamentoUsuario> listar(Usuario usuario) throws IOException{
		String jpql = "select u from EquipamentoUsuario u where u.usuario = :usuario ORDER BY u.id DESC";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("usuario", usuario);
		
		@SuppressWarnings("unchecked")
		List<EquipamentoUsuario> result = query.getResultList();
		
		for (EquipamentoUsuario equipamentoUsuario : result) {
			String jpql2 = "select m from Manutencao m where m.equipamentoUsuario.equipamento = :equipamento";			
			
			Query query2 = manager.createQuery(jpql2);
			query2.setParameter("equipamento", equipamentoUsuario.getEquipamento());
			
			List<Manutencao> manutencoes= query2.getResultList();
			equipamentoUsuario.setManutencoes(manutencoes);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public EquipamentoUsuario buscar(String numeroPatrimonio) throws IOException{
		String jpql = "select u from EquipamentoUsuario u where u.numeroPatrimonio = :numeroPatrimonio";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("numeroPatrimonio", numeroPatrimonio);
		
		@SuppressWarnings("unchecked")
		List<EquipamentoUsuario> result = query.getResultList();		
		
		return result.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public EquipamentoUsuario buscarPorEquipamento(int id) throws IOException{
		String jpql = "select u from EquipamentoUsuario u where u.equipamento.id = :id";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<EquipamentoUsuario> result = query.getResultList();		
		
		return result.get(0);
	}
}