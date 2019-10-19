package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.PessoaFisica;
import api.model.dao.PessoaFisicaDAO;

@Service
public class PessoaFisicaService {

	@Autowired
	private PessoaFisicaDAO dao;
	
	@Transactional
	public PessoaFisica inserir(PessoaFisica pessoaFisica) throws IOException{
		return dao.inserir(pessoaFisica);
	}
	
	public PessoaFisica buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	@Transactional
	public PessoaFisica atualizar(PessoaFisica pessoaFisica) throws IOException{
		return dao.atualizar(pessoaFisica);
	}
	
	public void remover(PessoaFisica pessoaFisica) throws IOException{
		dao.remover(pessoaFisica);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaFisica> listar() throws IOException{
		return dao.listar();
	}
}