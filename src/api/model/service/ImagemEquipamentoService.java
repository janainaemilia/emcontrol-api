package api.model.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.model.entity.Equipamento;
import api.model.entity.ImagemEquipamento;
import api.model.dao.ImagemEquipamentoDAO;

@Service
public class ImagemEquipamentoService {

	@Autowired
	private ImagemEquipamentoDAO dao;
	
	public ImagemEquipamento inserir(ImagemEquipamento imagem) throws IOException{
		return dao.inserir(imagem);
	}
	
	public ImagemEquipamento buscar(int id) throws IOException{
		return dao.buscar(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<ImagemEquipamento> listarImagemEquipamento() throws IOException{
		return dao.listarImagemEquipamento();
	}	
	
	@SuppressWarnings("unchecked")
	public List<ImagemEquipamento> listarImagemEquipamento(Equipamento equipamento) throws IOException{
		return dao.listarImagemEquipamento(equipamento);
	}	
}