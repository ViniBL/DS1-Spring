package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.GenericUsuario;

public interface IGenericUsuarioService {
    
    GenericUsuario buscarPorId(Long id);

	List<GenericUsuario> buscarTodos();

	void salvar(GenericUsuario usuario);

	void excluir(Long id);	

	GenericUsuario buscarPorLogin(String username);
}
