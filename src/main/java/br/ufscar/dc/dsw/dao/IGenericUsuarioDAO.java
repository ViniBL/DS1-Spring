package br.ufscar.dc.dsw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.ufscar.dc.dsw.domain.GenericUsuario;

@SuppressWarnings("unchecked")
public interface IGenericUsuarioDAO extends CrudRepository<GenericUsuario, Long> {
    GenericUsuario findById(long id);

	List<GenericUsuario> findAll();
	
	GenericUsuario save(GenericUsuario usuario);

	void deleteById(Long id);
	
    @Query("SELECT u FROM GenericUsuario u WHERE u.username = :username")
    public GenericUsuario getGenericUserByUsername(@Param("username") String username);
}
