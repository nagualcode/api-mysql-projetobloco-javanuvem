package br.com.infnet.apiclientes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.apiclientes.model.negocio.Cliente;
import br.com.infnet.apiclientes.model.repository.IClienteRepository;

@Service
public class ClienteService {

	@Autowired private IClienteRepository crepository;
	
	public Cliente clientePorId(Integer id) {
		return crepository.findById(id).orElse(null);
	}

	public List<Cliente> clienteLista(){
		return (List<Cliente>)crepository.findAll();
	}
	
	public void incluirCliente(Cliente cliente) {
		crepository.save(cliente);
	}
	
	public void excluirCliente(Integer id) {
		crepository.deleteById(id);
	}
}
