package br.ufscar.dc.dsw.dao;

import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
//import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;

@SuppressWarnings("unchecked")
public interface IPacoteDAO extends CrudRepository<Pacote, Long>{

	Pacote findById(long id);

	List<Pacote> findAll();
	
	Pacote save(Pacote pacote);

	void deleteById(Long id);

	//@Query("SELECT * FROM Pacote WHERE agencia_id = :agencia_id")
	public List<Pacote> findAllByAgencia(Agencia a);
}