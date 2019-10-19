package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import api.model.entity.Equipamento;
import api.model.entity.EquipamentoUsuario;
import api.model.entity.Manutencao;
import api.model.entity.Usuario;

@Repository
public class ManutencaoDAO {

	@PersistenceContext
	EntityManager manager;
	
	public Manutencao inserir(Manutencao manutencao) throws IOException{
		manager.persist(manutencao);
		return manutencao;
	}
	
	public Manutencao buscar(int id) throws IOException{
		return manager.find(Manutencao.class, id);
	}
	
	public void atualizar(Manutencao manutencao) throws IOException{
		manager.merge(manutencao);
	}
	
	public void remover(Manutencao manutencao) throws IOException{
		manager.remove(manager.find(Manutencao.class, manutencao.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<Manutencao> listar() throws IOException{
		return manager.createQuery("select f from Manutencao f").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Manutencao> listar(EquipamentoUsuario equipamentoUsuario) throws IOException{		
		String jpql = "select m from Manutencao m where m.equipamentoUsuario = :equipamentoUsuario";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("equipamentoUsuario", equipamentoUsuario);
		
		@SuppressWarnings("unchecked")
		List<Manutencao> result = query.getResultList();
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<EquipamentoUsuario> listar(Usuario usuario) throws IOException{		
				
		String equipamentos = "select e from EquipamentoUsuario e where e.usuario = :usuario";	
		
		Query query = manager.createQuery(equipamentos);
		query.setParameter("usuario", usuario);
		
		List<EquipamentoUsuario> result = query.getResultList();
		
		for (EquipamentoUsuario equipamentoUsuario : result) {
			String jpql = "select m from Manutencao m where m.equipamentoUsuario.equipamento = :equipamento";			
			
			Query query2 = manager.createQuery(jpql);
			query2.setParameter("equipamento", equipamentoUsuario.getEquipamento());
			
			List<Manutencao> manutencoes= query2.getResultList();
			equipamentoUsuario.setManutencoes(manutencoes);
		}
		
		System.out.println(result);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Manutencao> listar2(Usuario usuario) throws IOException{		
				
		String equipamentos = "select e from Manutencao e where e.equipamentoUsuario.usuario = :usuario";	
		
		Query query = manager.createQuery(equipamentos);
		query.setParameter("usuario", usuario);
		
		List<Manutencao> result = query.getResultList();
		
		/*for (EquipamentoUsuario equipamentoUsuario : result) {
			String jpql = "select m from Manutencao m where m.equipamentoUsuario.equipamento = :equipamento";			
			
			Query query2 = manager.createQuery(jpql);
			query2.setParameter("equipamento", equipamentoUsuario.getEquipamento());
			
			List<Manutencao> manutencoes= query2.getResultList();
			equipamentoUsuario.setManutencoes(manutencoes);
		}*/
		
		System.out.println(result);
		return result;
	}
}