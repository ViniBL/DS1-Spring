package br.ufscar.dc.dsw.service.impl;

import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.ufscar.dc.dsw.dao.IAgenciaDAO;
import br.ufscar.dc.dsw.dao.IPacoteDAO;
import br.ufscar.dc.dsw.domain.Agencia;
import br.ufscar.dc.dsw.domain.Pacote;
import br.ufscar.dc.dsw.service.spec.IPacoteService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Service
@Transactional(readOnly = false)
public class PacoteService implements IPacoteService {

	@Autowired
	IPacoteDAO dao;

	@Autowired
	IAgenciaDAO adao;
	
	public void salvar(Pacote pacote) {
		dao.save(pacote);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Pacote buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	//@Transactional(readOnly = true)
	public List<Pacote> buscarTodos() {
        return dao.findAll(new Specification<Pacote>() {
            @Override
            public Predicate toPredicate(Root<Pacote> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        });
    }

	@Transactional(readOnly = true)
	public List<Pacote> buscarTodosPorAgencia(Agencia agencia){
		return dao.findAllByAgencia(agencia);
	}

	@Transactional(readOnly = true)
	public List<Pacote> buscarTodosPorCidade(String cidade){
		return dao.findAllByCidade(cidade);
	}

	@Transactional(readOnly = true)
	public List<Pacote> buscarTodosPorEstado(String estado){
		return dao.findAllByEstado(estado);
	}

	@Transactional(readOnly = true)
	public List<Pacote> buscarTodosPorPais(String pais){
		return dao.findAllByPais(pais);
	}

	@Transactional(readOnly = true)
	public List<Pacote> buscarTodosPorDataPartida(String dataPartida){
		return dao.findAllByDataPartida(dataPartida);
	}

	//@Transactional(readyOnly = true)
	public List<Pacote> findByCriteria(String cidade, String estado, String pais, String dataPartida, String agencia){
		return dao.findAll(new Specification<Pacote>() {
			@Override
			public Predicate toPredicate(Root<Pacote> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				if(cidade!=null) {
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("cidade"), "%"+cidade+"%")));
				}
				if(estado!=null){
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("estado"), "%"+estado+"%")));
				}
				if(pais!=null){
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("pais"), "%"+pais+"%")));
				}
				if(dataPartida!=null){
					predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("dataPartida"), "%"+dataPartida+"%")));
				}
				if(agencia!=null){
					Agencia agenciaf = adao.getAgencyByName(agencia);
					predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("agencia"), agenciaf)));
				}
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		});
	}
}
