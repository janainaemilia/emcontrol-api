package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import api.model.entity.PessoaJuridica;

@Repository
public class PessoaJuridicaDAO {

	@PersistenceContext
	EntityManager manager;
	
	public PessoaJuridica inserir(PessoaJuridica pessoaJuridica) throws IOException{
		manager.persist(pessoaJuridica);
		return pessoaJuridica;
	}
	
	public PessoaJuridica buscar(int id) throws IOException{
		return manager.find(PessoaJuridica.class, id);
	}
	
	public PessoaJuridica atualizar(PessoaJuridica pessoaJuridica) throws IOException{
		return manager.merge(pessoaJuridica);
	}
	
	public void remover(PessoaJuridica pessoaJuridica) throws IOException{
		manager.remove(manager.find(PessoaJuridica.class, pessoaJuridica.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> listar() throws IOException{
		return manager.createQuery("select f from PessoaJuridica f").getResultList();
	}
}