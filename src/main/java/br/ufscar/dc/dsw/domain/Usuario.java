package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@SuppressWarnings("serial")
@Entity
@Table(name = "Usuario")
public class Usuario extends GenericUsuario {
       
    @NotBlank
    @Column(nullable = false, length = 14)
    private String CPF;

	@NotBlank
    @Column(nullable = false, length = 14)
    private String telefone;

	@NotBlank
    @Column(nullable = false, length = 1)
    private String sexo;

	@NotBlank
    @Column(nullable = false, length = 14)
    private String dataNascimento;

	
    
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	
}