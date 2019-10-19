package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.Cliente;
import api.model.entity.Usuario;
import api.model.dao.ClienteDAO;

@Service
public class ClienteService {

	@Autowired
	private ClienteDAO dao;
	
	@Transactional
	public Cliente inserir(Cliente cliente) throws IOException{
		return dao.inserir(cliente);
	}
	
	public Cliente buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	public Cliente buscarPorUsuario(Usuario usuario) throws IOException{
		return dao.buscar(usuario);
	}

	public Cliente buscar(String email ) throws IOException{
		return dao.buscar(email);
	}

	@Transactional
	public Cliente atualizar(Cliente cliente) throws IOException{
		dao.atualizar(cliente);
		return cliente;
	}
	
	public void remover(Cliente cliente) throws IOException{
		dao.remover(cliente);
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> listar() throws IOException{
		return dao.listar();
	}
}