package api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import api.model.entity.Categoria;
import api.model.service.CategoriaService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method=RequestMethod.POST, value="categoria/novo")
	public @ResponseBody Categoria cadastrarCategoria(@RequestBody Categoria categoria){
		try{
			Categoria novoCategoria = categoriaService.inserir(categoria);
			return novoCategoria;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="categoria/editar")
	public @ResponseBody Categoria editarCategoria(@RequestBody Categoria categoria){
		try{
			Categoria categoriaEditado = categoriaService.atualizar(categoria);
			return categoriaEditado;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="categorias")
	public @ResponseBody List<Categoria> listaCategoria(){
		try{
			return categoriaService.listarCategoria();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="subcategorias")
	public @ResponseBody List<Categoria> listaSubategoria(){
		try{
			return categoriaService.listarSubcategoria();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
}
