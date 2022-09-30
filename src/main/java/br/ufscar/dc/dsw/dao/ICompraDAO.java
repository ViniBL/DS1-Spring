package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.domain.Usuario;

@SuppressWarnings("unchecked")
public interface ICompraDAO extends CrudRepository<Compra, Long>{

	Compra findById(long id);

	List<Compra> findAllByUsuario(Usuario u);
	
	Compra save(Compra compra);

	@Modifying
	@Query("UPDATE Compra SET status='CANCELADO' WHERE id=:id")
	void cancelarById(@Param("id") Long id);
}