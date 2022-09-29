package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;


@SuppressWarnings("unchecked")
//@Repository
public interface IPacoteDAO extends CrudRepository<Pacote, Long>, JpaSpecificationExecutor<Pacote>{

	Pacote findById(long id);

	List<Pacote> findAll();
	
	Pacote save(Pacote pacote);

	void deleteById(Long id);

	public List<Pacote> findAllByAgencia(Agencia a);

	@Query("SELECT p FROM Pacote p WHERE p.cidade like %?1%")
	public List<Pacote> findAllByCidade(String cidade);

	@Query("SELECT p FROM Pacote p WHERE p.estado like %?1%")
	public List<Pacote> findAllByEstado(String estado);

	@Query("SELECT p FROM Pacote p WHERE p.pais like %?1%")
	public List<Pacote> findAllByPais(String pais);

	@Query("SELECT p FROM Pacote p WHERE p.dataPartida like %?1%")
	public List<Pacote> findAllByDataPartida(String dataPartida);

}