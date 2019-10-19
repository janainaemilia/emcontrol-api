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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import api.model.entity.Cliente;
import api.model.entity.Mailer;
import api.model.entity.Usuario;
import api.model.service.ClienteService;
import api.model.service.UsuarioService;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.POST, value="validate")
	public @ResponseBody Usuario login(@RequestBody Usuario usuario){
		try{
			Usuario result = usuarioService.login(usuario);
			
			if(result != null)
				return result;
			else
				return null;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(method=RequestMethod.POST, value="usuario/novo")
	public @ResponseBody Usuario cadastrarUsuario(@RequestBody Usuario usuario){
		try{
			Usuario novoUsuario = usuarioService.inserir(usuario);			
			return novoUsuario;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="usuario/editar")
	public @ResponseBody Usuario editarUsuario(@RequestBody Usuario usuario){
		try{
			Usuario usuarioEditado = usuarioService.atualizar(usuario);
			return usuarioEditado;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="recuperarSenha")
	public @ResponseBody boolean recuperarUsuario(@RequestBody Cliente cliente){
		try{
			String email = cliente.getEmail();
			cliente = clienteService.buscar(email);
			
			if(cliente != null) {
				Mailer mail = new Mailer();				
				String newPass = mail.sendMail(email);
				
				if(newPass != null) {
					clienteService.atualizar(cliente);
					
					return true;
				}
			}
			
			return false;
						
		} catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="usuarios")
	public @ResponseBody List<Usuario> listaUsuario(){
		try{
			return usuarioService.listar();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
}