package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Agencia;

@SuppressWarnings("unchecked")
public interface IAgenciaDAO extends CrudRepository<Agencia, Long>{

	Agencia findById(long id);
	
	Agencia findByCNPJ (String CNPJ);

	List<Agencia> findAll();
	
	Agencia save(Agencia agencia);

	void deleteById(Long id);

	@Query("SELECT a FROM Agencia a WHERE a.username = :username")
    public Agencia getAgencyByUsername(@Param("username") String username);
}
