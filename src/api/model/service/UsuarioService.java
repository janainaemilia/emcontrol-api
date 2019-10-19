package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import api.model.entity.Usuario;
import api.model.dao.UsuarioDAO;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioDAO dao;
	
	public Usuario login(Usuario user) throws IOException {		
		Usuario userLogged = dao.login(user);
		if(userLogged != null)
			return userLogged;
		else
			return null;		
	}
	
	@Transactional
	public Usuario inserir(Usuario usuario) throws IOException{
		return dao.inserir(usuario);
	}
	
	public Usuario buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	public Usuario buscar(Usuario usuario) throws IOException{
		return dao.buscar(usuario);
	}
	
	@Transactional
	public Usuario atualizar(Usuario usuario) throws IOException{
		return dao.atualizar(usuario);
	}
	
	public void remover(Usuario usuario) throws IOException{
		dao.remover(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listar() throws IOException{
		return dao.listar();
	}
}