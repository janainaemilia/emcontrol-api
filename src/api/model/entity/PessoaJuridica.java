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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.br.CNPJ;

/**
 * @author Team Inside
 *
 */
@Entity
@Table(name="tb_pessoa_juridica")
public class PessoaJuridica {

	@Id
	@Column(name="ID_PESSOA_JURIDICA")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="id_cliente")
	private Cliente cliente;
	
	@Column(name="razao_social")
	private String razaoSocial;
	
	@Column(name="cnpj_value")
	private String cnpj;
	
	private String ramo;

	public PessoaJuridica() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	
	@Override
	public String toString() {
		return "PessoaJuridica [id=" + id + ", cliente=" + cliente + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj
				+ ", ramo=" + ramo + "]";
	}
	
}

