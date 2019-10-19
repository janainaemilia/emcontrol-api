package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.EquipamentoUsuario;
import api.model.entity.Usuario;
import api.model.dao.EquipamentoUsuarioDAO;

@Service
public class EquipamentoUsuarioService {

	@Autowired
	private EquipamentoUsuarioDAO dao;
	
	@Transactional
	public EquipamentoUsuario inserir(EquipamentoUsuario equipamentoUsuario) throws IOException{
		return dao.inserir(equipamentoUsuario);
	}
	
	public EquipamentoUsuario buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	public EquipamentoUsuario buscaPorNumeroPatrimonio(String numeroPatrimonio) throws IOException{
		return dao.buscar(numeroPatrimonio);
	}
	
	public EquipamentoUsuario buscarPorEquipamento(int id) throws IOException{
		return dao.buscarPorEquipamento(id);
	}
	
	@Transactional
	public EquipamentoUsuario atualizar(EquipamentoUsuario equipamentoUsuario) throws IOException{
		return dao.atualizar(equipamentoUsuario);
	}
	
	public void remover(EquipamentoUsuario equipamentoUsuario) throws IOException{
		dao.remover(equipamentoUsuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<EquipamentoUsuario> listar() throws IOException{
		return dao.listar();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<EquipamentoUsuario> listar(Usuario usuario) throws IOException{
		return dao.listar(usuario);
	}
}