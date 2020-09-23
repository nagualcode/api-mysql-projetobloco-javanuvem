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

import br.com.infnet.apiclientes.model.negocio.Boleto;
import br.com.infnet.apiclientes.model.negocio.Cliente;
import br.com.infnet.apiclientes.model.negocio.Servico;
import br.com.infnet.apiclientes.model.service.BoletoService;
import br.com.infnet.apiclientes.model.service.ClienteService;
import br.com.infnet.apiclientes.model.service.ServicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/boleto")
public class BoletoController {

	@Autowired private BoletoService bservice;
	
	@Autowired private ClienteService bcservice;
	
	@Autowired private ServicoService bsservice;

	@ApiOperation(value = "Retornar uma lista de boletos")
	@GetMapping
	public List<Boleto> obterBoletos(){		
		return bservice.obterBoletos();
	}

	@RequestMapping(		
			value = "",
			method = RequestMethod.POST,
			produces = {"application/json", "application/xml"}
			)	
	@ApiOperation(value = "Cadastrar um boleto")
	public void incluirboleto(
				@RequestBody Boleto boleto
			) {
		
		Cliente cliente = bcservice.clientePorId(boleto.getIdcliente());
		System.out.println("APi include client: " + cliente);
		boleto.setCliente(cliente);
		
		Servico servico = bsservice.servicoPorId(boleto.getIdservico());
		System.out.println("APi include servico: " + servico);
		boleto.setServico(servico);
		
		
		
		System.out.println("Novo boleto pronto da api:" + boleto);
		bservice.incluirBoleto(boleto);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Cliente retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
	@ApiOperation(value = "Obter um boleto pela chave-primária")
	@GetMapping(value = "/obter")
	public Boleto BoletoPorId(
				@RequestParam Integer id
			) {
		return bservice.boletoPorId(id);
	}
	
	@ApiOperation(value = "Excluir um boleto")
	@DeleteMapping(value = "/del/{id}")
	public void excluir(
				@PathVariable Integer id
			) {
		bservice.excluirBoleto(id);
	}
}