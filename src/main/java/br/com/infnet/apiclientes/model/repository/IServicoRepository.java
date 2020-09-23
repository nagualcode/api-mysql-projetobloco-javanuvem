package br.com.infnet.apiclientes.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.apiclientes.model.negocio.Servico;

@Repository
public interface IServicoRepository extends CrudRepository<Servico, Integer> {

}
