package api.model.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import api.model.entity.PessoaFisica;

@Repository
public class PessoaFisicaDAO {

	@PersistenceContext
	EntityManager manager;
	
	public PessoaFisica inserir(PessoaFisica pessoaFisica) throws IOException{
		manager.persist(pessoaFisica);
		return pessoaFisica;
	}
	
	public PessoaFisica buscar(int id) throws IOException{
		return manager.find(PessoaFisica.class, id);
	}
	
	public PessoaFisica atualizar(PessoaFisica pessoaFisica) throws IOException{
		return manager.merge(pessoaFisica);
	}
	
	public void remover(PessoaFisica pessoaFisica) throws IOException{
		manager.remove(manager.find(PessoaFisica.class, pessoaFisica.getId()));
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> listar() throws IOException{
		return manager.createQuery("select f from PessoaFisica f").getResultList();
	}
}