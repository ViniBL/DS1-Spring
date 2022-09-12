package br.ufscar.dc.dsw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IGenericUsuarioDAO;
import br.ufscar.dc.dsw.domain.GenericUsuario;
import br.ufscar.dc.dsw.service.spec.IGenericUsuarioService;

@Service
@Transactional(readOnly = false)
public class GenericUsuarioService implements IGenericUsuarioService {

	@Autowired
	IGenericUsuarioDAO dao;

	public void salvar(GenericUsuario genericUsuario) {
		dao.save(genericUsuario);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public GenericUsuario buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<GenericUsuario> buscarTodos() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public GenericUsuario buscarPorLogin(String username){
		return dao.getGenericUserByUsername(username);
	}
}
