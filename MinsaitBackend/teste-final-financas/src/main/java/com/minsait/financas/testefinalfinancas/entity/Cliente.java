package com.minsait.financas.testefinalfinancas.entity;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@Entity

public class Cliente {
	
	@Id
	
	private Long cpf; 
	
	@NotEmpty(message = "Nome é obrigatório.")
	private String nome;
	
	
	private String tel;
	private String cep;
	private String rua;
	private int numeroDaResidencia;
	private BigDecimal rendimentoMensal;

	public Cliente() {
		
	}
	
	public Cliente(String nome, String tel, String cep,String rua, int numeroDaResidencia, BigDecimal rendimentoMensal) {
		this.nome = nome;
		this.tel = tel;
		this.cep = cep;
		this.rua = rua;
		this.numeroDaResidencia = numeroDaResidencia;
		this.rendimentoMensal = rendimentoMensal;
	}

	public Cliente(String tel, String cep,String rua, Integer numeroDaResidencia, BigDecimal rendimentoMensal) {
		this.tel = tel;
		this.cep = cep;
		this.rua = rua;
		this.numeroDaResidencia = numeroDaResidencia;
		this.rendimentoMensal = rendimentoMensal;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
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
	public int getNumeroDaResidencia() {
		return numeroDaResidencia;
	}
	public void setNumeroDaResidencia(int numeroDaResidencia) {
		this.numeroDaResidencia = numeroDaResidencia;
	}
	public BigDecimal getRendimentoMensal() {
		return rendimentoMensal;
	}
	public void setRendimentoMensal(BigDecimal rendimentoMensal) {
		this.rendimentoMensal = rendimentoMensal;
	}
}
