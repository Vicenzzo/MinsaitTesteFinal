package com.minsait.financas.testefinalfinancas.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Emprestimo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long CPFCliente;
	private BigDecimal valorIncial;
	private BigDecimal valorFinal;
	private String relacionamento;
	
	
	
	
	public Emprestimo() {
		
	}

	public Emprestimo(BigDecimal valorIncial, BigDecimal valorFinal, String relacionamento,Long CPFCliente) {
		this.valorIncial = valorIncial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		this.CPFCliente = CPFCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public BigDecimal getValorIncial() {
		return valorIncial;
	}

	public void setValorIncial(BigDecimal valorIncial) {
		this.valorIncial = valorIncial;
	}

	public BigDecimal getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(BigDecimal valorFinal) {
		this.valorFinal = valorFinal;
	}

	public String getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(String relacionamento) {
		this.relacionamento = relacionamento;
	}
	public Long getCPFCliente() {
		return CPFCliente;
	}
	public void setCPFCliente(Long clienteRetorno) {
		this.CPFCliente = clienteRetorno;
	}
}
