package api.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Team Inside
 *
 */
@Entity
@Table(name="tb_equipamento")
public class Equipamento {

	@Id
	@Column(name="ID_EQUIPAMENTO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String marca;

	private String modelo;

	private String nome;
	
	private String imagem;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "equipamento", fetch = FetchType.LAZY)
	private List<ImagemEquipamento> imagens;

	public Equipamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", marca=" + marca + ", modelo=" + modelo
				+ ", nome=" + nome + ", categoria=" + categoria + "imagem=" + imagem + "]";
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
}
