package br.ufscar.dc.dsw.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.ICompraDAO;
import br.ufscar.dc.dsw.domain.Compra;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.service.spec.ICompraService;

@Service
@Transactional(readOnly = false)
public class CompraService implements ICompraService {

	@Autowired
	ICompraDAO dao;
	
	public void salvar(Compra compra) {
		dao.save(compra);
	}

	@Transactional(readOnly = true)
	public Compra buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Compra> buscarTodosPorUsuario(Usuario u) {
		return dao.findAllByUsuario(u);
	}

	@Transactional
	@Modifying
	public boolean excluirPorId(Long id){
		Compra compra = this.buscarPorId(id);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataPartida = compra.getPacote().getDataPartida();
		LocalDate dataAtual = LocalDate.now();
		LocalDate dp = LocalDate.parse(dataPartida, formatter);
    	dp = dp.minusDays(5);
    
    	if(dp.isAfter(dataAtual)){
			System.out.println("\n\nentrou no service e foi pro dao\n\n");
       		dao.cancelarById(id);
			return true;
		}else{
			return false;
		}
    
	}
}
