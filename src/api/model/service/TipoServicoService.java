package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.entity.TipoServico;
import api.model.dao.TipoServicoDAO;

@Service
public class TipoServicoService {

	@Autowired
	private TipoServicoDAO dao;
	
	public TipoServico inserir(TipoServico tipoServico) throws IOException{
		return dao.inserir(tipoServico);
	}
	
	public TipoServico buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	public void atualizar(TipoServico tipoServico) throws IOException{
		dao.atualizar(tipoServico);
	}
	
	public void remover(TipoServico tipoServico) throws IOException{
		dao.remover(tipoServico);
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoServico> listar() throws IOException{
		return dao.listar();
	}
}