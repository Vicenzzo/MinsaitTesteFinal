package com.minsait.financas.testefinalfinancas.entity;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Entity

public class Cliente{
	
	@Id
	@NotNull(message = "O CPF é obrigatório")
	private Long cpf; 
	
	@NotBlank(message = "Nome é obrigatório.")
	private String nome;
	
	@NotNull(message="O telefone é obrigatório")
	private Long telefone;
	
	@NotNull(message="O CEP é obrigatório")
	private String cep;
	
	@NotBlank(message="O endereço é obrigatório")
	private String rua;
	
	@NotNull(message="O numero da residencia é obrigatorio")
	private Integer numeroDaResidencia;
	
	@NotNull(message="O rendimento mensal é obrigatório")
	private BigDecimal rendimentoMensal;

	public Cliente() {
		
	}
	
	public Cliente(String nome, Long telefone, String cep,String rua, Integer numeroDaResidencia, BigDecimal rendimentoMensal) {
		this.nome = nome;
		this.telefone = telefone;
		this.cep = cep;
		this.rua = rua;
		this.numeroDaResidencia = numeroDaResidencia;
		this.rendimentoMensal = rendimentoMensal;
	}

	public Cliente(Long telefone, String cep,String rua, Integer numeroDaResidencia, BigDecimal rendimentoMensal) {
		this.telefone = telefone;
		this.cep = cep;
		this.rua = rua;
		this.numeroDaResidencia = numeroDaResidencia;
		this.rendimentoMensal = rendimentoMensal;
	}
	
	public Cliente (Long cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCPF() {
		return cpf;
	}
	public void setCPF(Long cpf) {
		this.cpf = cpf;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getCEP() {
		return cep;
	}
	public void setCEP(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumeroDaResidencia() {
		return numeroDaResidencia;
	}
	public void setNumeroDaResidencia(Integer numeroDaResidencia) {
		this.numeroDaResidencia = numeroDaResidencia;
	}
	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}
	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
}
