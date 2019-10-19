package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.entity.Categoria;
import api.model.dao.CategoriaDAO;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaDAO dao;
	
	public Categoria inserir(Categoria categoria) throws IOException{
		return dao.inserir(categoria);
	}
	
	public Categoria buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	public Categoria atualizar(Categoria categoria) throws IOException{
		return dao.atualizar(categoria);
	}
	
	public void remover(Categoria categoria) throws IOException{
		dao.remover(categoria);
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarCategoria() throws IOException{
		return dao.listarCategoria();
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> listarSubcategoria() throws IOException{
		return dao.listarSubcategoria();
	}
}