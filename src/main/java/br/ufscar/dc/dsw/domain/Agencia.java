package br.ufscar.dc.dsw.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import br.ufscar.dc.dsw.validation.UniqueCNPJ;

@SuppressWarnings("serial")
@Entity
@Table(name = "Agencia")
public class Agencia extends GenericUsuario {

	@UniqueCNPJ (message = "{Unique.agencia.CNPJ}")
	@NotBlank
	@Size(min = 18, max = 18, message = "{Size.agencia.CNPJ}")
	@Column(nullable = false, unique = true, length = 60)
	private String CNPJ;
	

	@NotBlank 
	@Size(min = 0, max = 256)
	@Column(nullable = false, length = 256)
	private String descricao;

	@OneToMany(mappedBy = "agencia")
	private List<Pacote> pacotes;

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	

	public List<Pacote> getPacotes() {
		return pacotes;
	}

	public void setPacotes(List<Pacote> pacotes) {
		this.pacotes = pacotes;
	}
}
