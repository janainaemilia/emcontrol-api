package api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Team Inside
 *
 */
@Entity
@Table(name="tb_imagem")
public class ImagemEquipamento {
	
	@Id
	@Column(name="id_imagem")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	private String nome;
	
	@ManyToOne
	@JoinColumn(name="id_equipamento")
	private Equipamento equipamento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}
	
	@Override
	public String toString() {
		return "ImagemEquipamento [id=" + id + ", nome=" + nome + "]";
	}	
}
