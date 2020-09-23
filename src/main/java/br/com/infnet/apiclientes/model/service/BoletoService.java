package br.com.infnet.apiclientes.model.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.infnet.apiclientes.model.negocio.Boleto;

import br.com.infnet.apiclientes.model.repository.IBoletoRepository;

@Service
public class BoletoService {

	@Autowired private IBoletoRepository brepository;
	
	public Boleto boletoPorId(Integer id) {
		return brepository.findById(id).orElse(null);
	}

	public List<Boleto> obterBoletos(){
		return (List<Boleto>)brepository.findAll();
	}
	
	public void incluirBoleto(Boleto boleto) {
		brepository.save(boleto);
	}
	
	public void excluirBoleto(Integer id) {
		brepository.deleteById(id);
	}
}
