package api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import api.model.entity.Cliente;
import api.model.entity.EquipamentoUsuario;
import api.model.entity.PessoaFisica;
import api.model.entity.PessoaJuridica;
import api.model.entity.Usuario;
import api.model.service.ClienteService;
import api.model.service.PessoaFisicaService;
import api.model.service.PessoaJuridicaService;
import api.model.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PessoaFisicaService pessoaFisicaService;
	
	@Autowired
	private PessoaJuridicaService pessoaJuridicaService;
	
	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(method=RequestMethod.GET, value="clientes")
	public @ResponseBody List<Cliente> listaCliente(){
		try{
			return clienteService.listar();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
		
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(method=RequestMethod.GET, value="cliente/usuario/{id}")
	public @ResponseBody Cliente buscarCliente(@PathVariable("id") int id){
		try{
			Usuario usuario = usuarioService.buscar(id);
			Cliente _cliente = clienteService.buscarPorUsuario(usuario);
			return _cliente;	
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="cliente/novo")
	public @ResponseBody Cliente cadastrarCliente(@RequestBody Cliente cliente){
		try{
			Cliente novoCliente = clienteService.inserir(cliente);			
			return novoCliente;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 36000)
	@RequestMapping(method=RequestMethod.POST, value="pessoafisica/novo")
	public @ResponseBody PessoaFisica cadastrarPessoaFisica(@RequestBody PessoaFisica pessoaFisica){
		try{
			PessoaFisica novaPessoaFisica = pessoaFisicaService.inserir(pessoaFisica);			
			return novaPessoaFisica;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="pessoafisica")
	public @ResponseBody PessoaFisica novaPessoaFisica(@RequestBody PessoaFisica pessoaFisica){
		try{
			PessoaFisica novaPessoaFisica = pessoaFisicaService.inserir(pessoaFisica);			
			return novaPessoaFisica;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(method=RequestMethod.POST, value="pessoajuridica/novo")
	public @ResponseBody PessoaJuridica cadastrarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica){
		try{			
			PessoaJuridica novaPessoaJuridica = pessoaJuridicaService.inserir(pessoaJuridica);		
			
			return novaPessoaJuridica;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(method=RequestMethod.POST, value="cliente/editar")
	public @ResponseBody Cliente editarPessoaFisica(@RequestBody Cliente cliente){
		try{
			Cliente clienteEditado = clienteService.atualizar(cliente);
			clienteEditado.setUsuario(usuarioService.atualizar(cliente.getUsuario()));
			return clienteEditado;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(method=RequestMethod.POST, value="pessoafisica/editar")
	public @ResponseBody PessoaFisica editarPessoaFisica(@RequestBody PessoaFisica pessoaFisica){
		try{
			Cliente clienteEditado = clienteService.atualizar(pessoaFisica.getCliente());
			pessoaFisica.setCliente(clienteEditado);
			
			return pessoaFisicaService.atualizar(pessoaFisica);
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
	@RequestMapping(method=RequestMethod.POST, value="pessoajuridica/editar")
	public @ResponseBody PessoaJuridica editarPessoaJuridica(@RequestBody PessoaJuridica pessoaJuridica){
		try{
			Cliente clienteEditado = clienteService.atualizar(pessoaJuridica.getCliente());
			pessoaJuridica.setCliente(clienteEditado);
			
			return pessoaJuridicaService.atualizar(pessoaJuridica);
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
}
