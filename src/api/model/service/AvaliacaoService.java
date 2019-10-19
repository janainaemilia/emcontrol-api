package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.Avaliacao;
import api.model.dao.AvaliacaoDAO;

@Service
public class AvaliacaoService {

	@Autowired
	private AvaliacaoDAO dao;
	
	@Transactional
	public Avaliacao inserir(Avaliacao avaliacao) throws IOException{
		return dao.inserir(avaliacao);
	}
	
	public Avaliacao buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	@Transactional
	public void atualizar(Avaliacao avaliacao) throws IOException{
		dao.atualizar(avaliacao);
	}
	
	public void remover(Avaliacao avaliacao) throws IOException{
		dao.remover(avaliacao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Avaliacao> listar() throws IOException{
		return dao.listar();
	}
}