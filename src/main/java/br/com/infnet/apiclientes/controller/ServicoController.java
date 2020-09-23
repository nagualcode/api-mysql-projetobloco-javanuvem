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

import br.com.infnet.apiclientes.model.negocio.Servico;
import br.com.infnet.apiclientes.model.service.ServicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/servico")
public class ServicoController {

	@Autowired private ServicoService sservice;

	@ApiOperation(value = "Retornar uma lista de serviços")
	@GetMapping
	public List<Servico> servicoLista(){		
		return sservice.servicoLista();
	}

	@RequestMapping(		
			value = "",
			method = RequestMethod.POST,
			produces = {"application/json", "application/xml"}
			)	
	@ApiOperation(value = "Cadastrar um servico")
	public void incluirServico(
				@RequestBody Servico servico
			) {
		sservice.incluirServico(servico);
	}
	
	@ApiResponses(value = {		
			@ApiResponse(code = 200, message = "Cliente retornada com sucesso"),
			@ApiResponse(code = 400, message = "Erro na chamada da API"),
			@ApiResponse(code = 500, message = "Erro no processamento da chamada")
	})			
	@ApiOperation(value = "Obter um servico pela chave-primária")
	@GetMapping(value = "/obter")
	public Servico ServicoPorId(
				@RequestParam Integer id
			) {
		return sservice.servicoPorId(id);
	}
	
	@ApiOperation(value = "Excluir um servico")
	@DeleteMapping(value = "/del/{id}")
	public void excluirservico(
				@PathVariable Integer id
			) {
		sservice.excluirServico(id);
	}
}