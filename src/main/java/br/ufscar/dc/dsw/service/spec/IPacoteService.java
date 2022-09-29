package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;

public interface IPacoteService {

	Pacote buscarPorId(Long id);
	
	List<Pacote> buscarTodos();
	
	void salvar(Pacote pacote);
	
	void excluir(Long id);

	List<Pacote> buscarTodosPorAgencia(Agencia agencia);

	List<Pacote> buscarTodosPorCidade(String cidade);

	List<Pacote> buscarTodosPorEstado(String estado);

	List<Pacote> buscarTodosPorPais(String pais);

	List<Pacote> buscarTodosPorDataPartida(String dataPartida);

	List<Pacote> findByCriteria(String cidade, String estado, String pais, String dataPartida, String agencia);
	
}
