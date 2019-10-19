package api.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import api.model.entity.Equipamento;
import api.model.entity.EquipamentoUsuario;
import api.model.entity.Manutencao;
import api.model.entity.TipoServico;
import api.model.entity.Usuario;
import api.model.service.EquipamentoService;
import api.model.service.EquipamentoUsuarioService;
import api.model.service.ManutencaoService;
import api.model.service.TipoServicoService;
import api.model.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class ManutencaoController {

	@Autowired
	private EquipamentoUsuarioService equipamentoUsuarioService;
	
	@Autowired
	private ManutencaoService manutencaoService;
	
	@Autowired
	private TipoServicoService tipoServicoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.POST, value="manutencao/novo")
	public @ResponseBody Manutencao novaManutencao(@RequestBody Manutencao manutencao){
		try{	            
			Manutencao novaManutencao = manutencaoService.inserir(manutencao);
			return novaManutencao;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="manutencoes")
	public @ResponseBody List<Manutencao> listar(){
		try{
			return manutencaoService.listar();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="manutencao/{id}")
	public @ResponseBody Manutencao buscar(@PathVariable("id") int id){
		try{
			return manutencaoService.buscar(id);			
		} catch(IOException e){ 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="manutencoes/equipamento/{id}")
	public @ResponseBody List<Manutencao> buscarPorEquipamento(@PathVariable("id") int id){
		try{
			EquipamentoUsuario equipamentoUsuario = equipamentoUsuarioService.buscarPorEquipamento(id);
			return manutencaoService.listarPorEquipamentoUsuario(equipamentoUsuario);			
		} catch(IOException e){ 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="manutencoes/usuario/{id}")
	public @ResponseBody List<EquipamentoUsuario> buscarPorUsuario(@PathVariable("id") int id){
		try{
			Usuario usuario = usuarioService.buscar(id);
			return manutencaoService.listarPorUsuario(usuario);			
		} catch(IOException e){ 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="manutencoes/usuario2/{id}")
	public @ResponseBody List<Manutencao> buscarPorUsuario2(@PathVariable("id") int id){
		try{
			Usuario usuario = usuarioService.buscar(id);
			return manutencaoService.listarPorUsuario2(usuario);			
		} catch(IOException e){ 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="manutencoes/{id}")
	public @ResponseBody List<EquipamentoUsuario> listarManutencoesPorEquipamento(@PathVariable("id") int id){
		try{
			Usuario usuario = usuarioService.buscar(id);
			List<EquipamentoUsuario> equipamentos = equipamentoUsuarioService.listar(usuario);
			
			for (EquipamentoUsuario equipamentoUsuario : equipamentos) {
				List<Manutencao> manutencoes = manutencaoService.listarPorEquipamentoUsuario(equipamentoUsuario);
				equipamentoUsuario.setManutencoes(manutencoes);
			}
			return equipamentos;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="tipoServicos")
	public @ResponseBody List<TipoServico> listarTipoServico(){
		try{
			return tipoServicoService.listar();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
}
