package br.com.infnet.apiclientes.model.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.apiclientes.model.negocio.Boleto;

@Repository
public interface IBoletoRepository extends CrudRepository<Boleto, Integer> {

}