package api.model.entity;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Team Inside
 *
 */
@Entity
@Table(name="tb_manutencao")
public class Manutencao {

	@Id
	@Column(name="ID_MANUTENCAO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_equip_usua")
	@JsonBackReference
	private	EquipamentoUsuario equipamentoUsuario;

	@ManyToOne
	@JoinColumn(name="id_tipo_servico")
	private TipoServico tipoServico;
	
	private String descricao;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date data;
	
	private double valor;
		
	@Column(name="PROVEDOR_SERVICO")
	private String provedorServico;
	
	private int garantia;
	
	@Lob
	@Column(name="NOTA_FISCAL", nullable=true)
	private byte[] notaFiscal;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date previsao;

	public Manutencao() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EquipamentoUsuario getEquipamentoUsuario() {
		return equipamentoUsuario;
	}

	public void setEquipamentoUsuario(EquipamentoUsuario equipamentoUsuario) {
		this.equipamentoUsuario = equipamentoUsuario;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getProvedorServico() {
		return provedorServico;
	}

	public void setProvedorServico(String provedorServico) {
		this.provedorServico = provedorServico;
	}

	public int getGarantia() {
		return garantia;
	}

	public void setGarantia(int garantia) {
		this.garantia = garantia;
	}

	public byte[] getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(byte[] notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Date getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Date previsao) {
		this.previsao = previsao;
	}

	@Override
	public String toString() {
		return "Manutencao [id=" + id + ", tipoServico=" + tipoServico
				+ ", descricao=" + descricao + ", data=" + data + ", valor=" + valor + ", provedorServico="
				+ provedorServico + ", garantia=" + garantia + ", notaFiscal=" + notaFiscal + ", previsao=" + previsao
				+ "]";
	}
}
