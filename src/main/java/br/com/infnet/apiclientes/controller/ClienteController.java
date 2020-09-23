package br.com.infnet.apiclientes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.infnet.apiclientes.model.negocio.Cliente;
import br.com.infnet.apiclientes.model.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired private ClienteService cservice;

	@ApiOperation(value = "Retornar uma lista de clientes")
	@GetMapping
	public List<Cliente> ClienteLista(){		
		return cservice.clienteLista();
	}

	@RequestMapping(		
			value = "",
			method = RequestMethod.POST,
			produces = {"application/json", "application/xml"}
			)	
	@ApiOperation(value = "Cadastrar um cliente")
	public void incluirCliente(
				@RequestBody Cliente cliente
			) {
		cservice.incluirCliente(cliente);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Cliente retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
	@ApiOperation(value = "Obter um cliente pela chave-primária")
	@GetMapping(value = "/obter")
	public Cliente ClientePorId(
				@RequestParam Integer id
			) {
		return cservice.clientePorId(id);
	}
	
	@ApiOperation(value = "Excluir um cliente")
	@DeleteMapping(value = "/del/{id}")
	public void excluir(
				@PathVariable Integer id
			) {
		cservice.excluirCliente(id);
	}
}