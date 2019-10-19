package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.Equipamento;
import api.model.entity.EquipamentoUsuario;
import api.model.entity.Manutencao;
import api.model.entity.Usuario;
import api.model.dao.ManutencaoDAO;

@Service
public class ManutencaoService {

	@Autowired
	private ManutencaoDAO dao;
	
	@Transactional
	public Manutencao inserir(Manutencao manutencao) throws IOException{
		return dao.inserir(manutencao);
	}
	
	public Manutencao buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	@Transactional
	public void atualizar(Manutencao manutencao) throws IOException{
		dao.atualizar(manutencao);
	}
	
	public void remover(Manutencao manutencao) throws IOException{
		dao.remover(manutencao);
	}
	
	@SuppressWarnings("unchecked")
	public List<Manutencao> listar() throws IOException{
		return dao.listar();
	}
	
	@SuppressWarnings("unchecked")
	public List<Manutencao> listarPorEquipamentoUsuario(EquipamentoUsuario equipamentoUsuario) throws IOException{
		return dao.listar(equipamentoUsuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<EquipamentoUsuario> listarPorUsuario(Usuario usuario) throws IOException{
		return dao.listar(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Manutencao> listarPorUsuario2(Usuario usuario) throws IOException{
		return dao.listar2(usuario);
	}
}