package br.com.infnet.apiclientes.model.negocio;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TServico")
@Inheritance(strategy = InheritanceType.JOINED)

public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	
	
	
	@ApiModelProperty(value = "A descrição do serviço")
	private String descricao;
	
	@ApiModelProperty(value = "O valor em reais")
	private String valor;
	
	


	@Override
	public String toString() {
		return String.format("%d - %s - %s", this.getId(), this.getDescricao(), this.getValor());
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	

	
	
	
}
