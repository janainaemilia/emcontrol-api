package api.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Team Inside
 *
 */
@Entity
@Table(name="tb_equip_usua")
public class EquipamentoUsuario {

	@Id
	@Column(name="ID_EQUIP_USUA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_equipamento")
	private Equipamento equipamento;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	@Column(name="NUMERO_PATRIMONIO")
	private String numeroPatrimonio;
	
	@Column(name="DT_AQUISICAO")
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataAquisicao;
		
	@OneToMany(mappedBy = "equipamentoUsuario", fetch=FetchType.LAZY)
	@JsonManagedReference
	private List<Manutencao> manutencoes = new ArrayList<>();

	public List<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(List<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	public EquipamentoUsuario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroPatrimonio() {
		return numeroPatrimonio;
	}

	public void setNumeroPatrimonio(String numeroPatrimonio) {
		this.numeroPatrimonio = numeroPatrimonio;
	}

	public Date getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(Date dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	@Override
	public String toString() {
		return "EquipamentoUsuario [id=" + id + ", equipamento=" + equipamento + ", usuario=" + usuario
				+ ", numeroPatrimonio=" + numeroPatrimonio + ", dataAquisicao=" + dataAquisicao + "]";
	}
}
