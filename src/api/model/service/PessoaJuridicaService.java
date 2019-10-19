package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.PessoaJuridica;
import api.model.dao.PessoaJuridicaDAO;

@Service
public class PessoaJuridicaService {

	@Autowired
	private PessoaJuridicaDAO dao;
	
	@Transactional
	public PessoaJuridica inserir(PessoaJuridica pessoaJuridica) throws IOException{
		return dao.inserir(pessoaJuridica);
	}
	
	public PessoaJuridica buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	@Transactional
	public PessoaJuridica atualizar(PessoaJuridica pessoaJuridica) throws IOException{
		return dao.atualizar(pessoaJuridica);
	}
	
	public void remover(PessoaJuridica pessoaJuridica) throws IOException{
		dao.remover(pessoaJuridica);
	}
	
	@SuppressWarnings("unchecked")
	public List<PessoaJuridica> listar() throws IOException{
		return dao.listar();
	}
}