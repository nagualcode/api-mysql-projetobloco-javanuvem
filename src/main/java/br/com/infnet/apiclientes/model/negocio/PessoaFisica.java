package br.com.infnet.apiclientes.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TFisica")
@PrimaryKeyJoinColumn(name = "idcliente")
@JsonTypeName("pf")
public class PessoaFisica extends Cliente {

	@ApiModelProperty(value = "O número do cpf")
	private String cpf;
	
	
	
	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



}