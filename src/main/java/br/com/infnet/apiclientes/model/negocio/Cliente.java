package br.com.infnet.apiclientes.model.negocio;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TCliente")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "tipoCliente"
		)
@JsonSubTypes({
	@JsonSubTypes.Type(value = PessoaJuridica.class, name = "pj"),
	@JsonSubTypes.Type(value = PessoaFisica.class, name = "pf")
})
public abstract class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	
	@ApiModelProperty(value = "O nome do cliente")
	private String nome;
	
	@ApiModelProperty(value = "Logradouro")
	private String logradouro;
	
	@ApiModelProperty(value = "Complemento")
	private String complemento;
	
	@ApiModelProperty(value = "Bairro")
	private String bairro;
	
	@ApiModelProperty(value = "Cidade")
	private String cidade;
	
	@ApiModelProperty(value = "Estado")
	private String uf;
	
	@ApiModelProperty(value = "Cep")
	private String cep;
	
	@ApiModelProperty(value = "Telefone")
	private String telefone;
	
	@ApiModelProperty(value = "Email")
	private String email;

	public Cliente() {
	}
	
	public Cliente(String nome) {
		this();
		this.setNome(nome);
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s", this.getId(), this.getNome());
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
