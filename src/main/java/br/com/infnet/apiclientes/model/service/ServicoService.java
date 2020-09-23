
package br.com.infnet.apiclientes.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.apiclientes.model.negocio.Servico;
import br.com.infnet.apiclientes.model.repository.IServicoRepository;

@Service
public class ServicoService {

	@Autowired private IServicoRepository srepository;
	
	public Servico servicoPorId(Integer id) {
		return srepository.findById(id).orElse(null);
	}

	public List<Servico> servicoLista(){
		return (List<Servico>)srepository.findAll();
	}
	
	public void incluirServico(Servico servico) {
		srepository.save(servico);
	}
	
	public void excluirServico(Integer id) {
		srepository.deleteById(id);
	}
}
