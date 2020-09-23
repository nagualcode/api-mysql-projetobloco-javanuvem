package br.com.infnet.apiclientes.model.negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonTypeName;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TJuridica")
@PrimaryKeyJoinColumn(name = "idcliente")
@JsonTypeName("pj")
public class PessoaJuridica extends Cliente {

	@ApiModelProperty(value = "O número do cnpj")
	private String cnpj;
	
	

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


}