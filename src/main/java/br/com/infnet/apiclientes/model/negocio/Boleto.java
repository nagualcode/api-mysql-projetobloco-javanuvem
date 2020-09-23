package br.com.infnet.apiclientes.model.negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TBoleto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Boleto {
	
	

	@ApiModelProperty(value = "ID do cliente recebedor")
	private Integer idcliente;
	
	@ApiModelProperty(value = "ID do servico sendo cobrado")
	private Integer idservico;
	
	@ManyToOne
	@JoinColumn(name = "idClienteEmissor")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "idServicoCobrado")
	private Servico servico;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@ApiModelProperty(value = "Codigo de Barras")
	private String codigo;


	@ApiModelProperty(value = "Data de vencimento")
	private String vencimento;

	@Override
	public String toString() {
		return String.format("Boleto %s - %s", this.getCodigo(), this.getVencimento());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Integer getIdservico() {
		return idservico;
	}

	public void setIdservico(Integer idservico) {
		this.idservico = idservico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}


	
	

	

}
