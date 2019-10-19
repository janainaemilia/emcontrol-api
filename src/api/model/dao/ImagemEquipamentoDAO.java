package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.Equipamento;
import api.model.entity.ImagemEquipamento;

@Repository
public class ImagemEquipamentoDAO {

	@PersistenceContext
	EntityManager manager;
	
	@Transactional
	public ImagemEquipamento inserir(ImagemEquipamento categoria) throws IOException{
		manager.persist(categoria);
		return categoria;
	}
	
	public ImagemEquipamento buscar(int id) throws IOException{
		return manager.find(ImagemEquipamento.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ImagemEquipamento> listarImagemEquipamento() throws IOException{
		return manager.createQuery("select f from ImagemEquipamento f").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<ImagemEquipamento> listarImagemEquipamento(Equipamento equipamento) throws IOException{
		String jpql = "select i from ImagemEquipamento i where i.equipamento = :equipamento";
				
		Query query = manager.createQuery(jpql);
		query.setParameter("equipamento", equipamento);
		
		@SuppressWarnings("unchecked")
		List<ImagemEquipamento> result = query.getResultList();
		
		return result;
	}
}