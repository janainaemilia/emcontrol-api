package api.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

import api.model.entity.Avaliacao;
import api.model.entity.Equipamento;
import api.model.entity.EquipamentoUsuario;
import api.model.entity.Imagem;
import api.model.entity.Usuario;
import api.model.service.AvaliacaoService;
import api.model.service.EquipamentoService;
import api.model.service.EquipamentoUsuarioService;
import api.model.service.ImagemEquipamentoService;
import api.model.service.UsuarioService;
import api.model.entity.ImagemEquipamento;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Controller
public class EquipamentoController {
	
	final String PATH = "C:/Users/Janaina/Documents/Faculdade/7_Semestre/TCC/Desenvolvimento/";
	
	@Autowired
	private EquipamentoService equipamentoService;
	
	@Autowired
	private EquipamentoUsuarioService equipamentoUsuarioService;
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ImagemEquipamentoService imagemEquipamentoService;
	
	@RequestMapping(method=RequestMethod.POST, value="equipamento/novo")
	public @ResponseBody Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento){
		try{
			Equipamento novoEquipamento = equipamentoService.inserir(equipamento);
			return novoEquipamento;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="equipamento/editar")
	public @ResponseBody EquipamentoUsuario editarEquipamento(@RequestBody EquipamentoUsuario equipamento){
		try{
			EquipamentoUsuario equipamentoEditado = equipamentoUsuarioService.atualizar(equipamento);
			Equipamento _equipamento= equipamentoService.atualizar(equipamento.getEquipamento());
			
			equipamentoEditado.setEquipamento(_equipamento);			
			return equipamentoEditado;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="equipamento/vincular-usuario")
	public @ResponseBody EquipamentoUsuario vincular(@RequestBody EquipamentoUsuario equipamentoUsuario){
		try{
			EquipamentoUsuario novoEquipamentoUsuario = equipamentoUsuarioService.inserir(equipamentoUsuario);
			return novoEquipamentoUsuario;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="equipamento/avaliar")
	public @ResponseBody Avaliacao avaliar(@RequestBody Avaliacao avaliacao){
		try{
			Avaliacao novaAvaliacao = avaliacaoService.inserir(avaliacao);
			return novaAvaliacao;
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="avaliacoes")
	public @ResponseBody List<Avaliacao> listaAvaliacoes(){
		try{
			return avaliacaoService.listar();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="equipamentos")
	public @ResponseBody List<Equipamento> listaEquipamento(){
		try{
			return equipamentoService.listar();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="equipamentos/{id}")
	public @ResponseBody List<EquipamentoUsuario> listaEquipamentoPorUsuario(@PathVariable("id") int id){
		try{
			Usuario usuario = usuarioService.buscar(id);
			return equipamentoUsuarioService.listar(usuario);			
		} catch(IOException e){
			e.printStackTrace(); 
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="equipamentos/categoria/{categoria}")
	public @ResponseBody List<Equipamento> listarPorCategoria(@PathVariable("categoria") String categoria){
		try{
			//Usuario usuario = usuarioService.buscar(id);
			return equipamentoService.listarPorCategoria(categoria);			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="nomeEquipamentoList")
	public @ResponseBody List<String> listarNomesEquipamentos(){
		try{
			return equipamentoService.listarNomesEquipamentos();			
		} catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="equipamento/{id}")
	public @ResponseBody EquipamentoUsuario buscar(@PathVariable("id") int id){
		try{
			EquipamentoUsuario equipamento = equipamentoUsuarioService.buscarPorEquipamento(id);
			equipamento.setManutencoes(null);
			return equipamento ;	
		} catch(IOException e){ 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.GET, value="imagens/{id}")
	public @ResponseBody List<ImagemEquipamento> buscarPorEquipamento(@PathVariable("id") int id){
		try{
			Equipamento equipamento = equipamentoService.buscar(id);
			return imagemEquipamentoService.listarImagemEquipamento(equipamento);			
		} catch(IOException e){ 
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="imagem/salvar")
	public @ResponseBody boolean salvarImagem(@RequestBody Imagem imagem) {
		try {
			boolean result = false;
			
			String imageUrl = imagem.getUrl().split(",")[1];			 
			String imageName = imagem.getNome(); 
			
			String destinationFile = PATH + "machinelearning/tf_files/test/" + imageName;				 
			result = saveImage(imageUrl, destinationFile);
			
			return result;
		} catch (Exception e) {
			return false;
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="equipamento/vincularImagens")
	public @ResponseBody boolean vincular(@RequestBody List<Imagem> imagens){
		try{
			boolean result = false;
			
			for (Imagem img : imagens) {
				 String imageUrl = img.getUrl().split(",")[1];			 
				 String imageName = img.getNome();
				 
				 //destinationFile =  location of the source java code
				 String destinationFile = PATH + "machinelearning/tf_files/test/" + imageName;				 
				 result = saveImage(imageUrl, destinationFile);
				 
				 String destinationFileReplica = PATH + "emcontrol/webapp/public/images/" + imageName;
				 saveImage(imageUrl, destinationFileReplica);
				 
				 if(result) {
					 EquipamentoUsuario equipamentoUsuario = equipamentoUsuarioService.buscaPorNumeroPatrimonio(img.getNumeroPatrimonio());
					 ImagemEquipamento imagem = new ImagemEquipamento();
					 imagem.setEquipamento(equipamentoUsuario.getEquipamento());
					 imagem.setNome(imageName);
					 
					 Equipamento equipamento = equipamentoUsuario.getEquipamento();
					 equipamento.setImagem(imageName);
					 
					 equipamentoService.atualizar(equipamento);					 
					 imagemEquipamentoService.inserir(imagem);
				 }
			}
			
			return result;
		} catch(IOException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean saveImage(String imageUrl, String destinationFile) throws IOException {	
		byte[] imageByte = Base64.getMimeDecoder().decode(imageUrl.getBytes(StandardCharsets.UTF_8));
		
		try (OutputStream stream = new FileOutputStream(destinationFile)) {
		    stream.write(imageByte);
		    return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	    /*try(InputStream in = new URL(imageUrl).openStream()){
	        Files.copy(in, Paths.get(destinationFile));
	        return true;
	    } catch(IOException e){
	        e.printStackTrace();
	        return false;
	    }*/
	}
}
