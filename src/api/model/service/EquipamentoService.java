package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.Equipamento;
import api.model.dao.EquipamentoDAO;

@Service
public class EquipamentoService {

	@Autowired
	private EquipamentoDAO dao;
	
	@Transactional
	public Equipamento inserir(Equipamento equipamento) throws IOException{
		return dao.inserir(equipamento);
	}
	
	public Equipamento buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	@Transactional
	public Equipamento atualizar(Equipamento equipamento) throws IOException{
		return dao.atualizar(equipamento);
	}
	
	public void remover(Equipamento equipamento) throws IOException{
		dao.remover(equipamento);
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> listar() throws IOException{
		return dao.listar();
	}
	
	@SuppressWarnings("unchecked")
	public List<Equipamento> listarPorCategoria(String categoria) throws IOException{
		return dao.listarPorCategoria(categoria);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> listarNomesEquipamentos() throws IOException{
		return dao.listarNomesEquipamentos();
	}
}