package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Pacote")
public class Pacote extends AbstractEntity<Long> {

	@NotNull(message = "{NotNull.pacote.data_partida}")
	@Column(nullable = false)
	private String data_partida;

	@NotNull(message = "{NotNull.pacote.duracao}")
	@Column(nullable = false)
	private int duracao;
    @NotBlank(message = "{NotBlank.pacote.cidade}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	//@Getter @Setter 
	private String cidade;

	@NotBlank(message = "{NotBlank.pacote.estado}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	//@Getter @Setter 
	private String estado;

	@NotBlank(message = "{NotBlank.pacote.pais}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	//@Getter @Setter 
	private String pais;

	@NotNull
	@Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	//@Getter @Setter 
	private BigDecimal valor;
	
	@NotBlank(message = "{NotBlank.pacote.descricao}")
	@Size(max = 256)
	@Column(nullable = false, length = 256)
	//@Getter @Setter 
	private String descricao;
    
	@NotNull(message = "{NotNull.pacote.agencia}")
	@ManyToOne
	@JoinColumn(name = "agencia_id")
	private Agencia agencia;


public void setDuracao(int duracao) {
	this.duracao = duracao;
}

public int getDuracao() {
	return duracao;
}
public BigDecimal getValor() {
	return valor;
}

public void setValor(BigDecimal valor) {
	this.valor = valor;
}

public String getDescricao() {
	return descricao;
}

public void setDescricao(String descricao) {
	this.descricao = descricao;
}

public String getCidade() {
	return cidade;
}

public void setCidade(String cidade) {
	this.cidade = cidade;
}

public String getEstado() {
	return estado;
}

public void setEstado(String estado) {
	this.estado = estado;
}

public String getPais() {
	return pais;
}

public void setPais(String pais) {
	this.pais = pais;
}

public Agencia getAgencia() {
	return agencia;
}

public void setAgencia(Agencia agencia) {
	this.agencia = agencia;
}

public String getData_partida() {
	return data_partida;
}

public void setData_partida(String data_partida) {
	this.data_partida = data_partida;
}

}