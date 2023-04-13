package com.minsait.financas.testefinalfinancas.entity;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity

public class Cliente{
	
	@Id
	
	private Long cpf; 
	
	@NotEmpty(message = "Nome é obrigatório.")
	private String nome;
	private Long telefone;
	private String cep;
	private String rua;
	private Integer numeroDaResidencia;
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
