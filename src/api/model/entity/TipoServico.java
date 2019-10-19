package api.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Team Inside
 *
 */
@Entity
@Table(name="tb_tipo_servico")
public class TipoServico {

	@Id
	@Column(name="ID_TIPO_SERVICO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="DESC_SERVICO")
	private String descricaoServico;

	public TipoServico() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescServico() {
		return this.descricaoServico;
	}

	public void setDescServico(String descServico) {
		this.descricaoServico = descServico;
	}

	@Override
	public String toString() {
		return "TipoServico [id=" + id + ", descricaoServico=" + descricaoServico + "]";
	}
}
