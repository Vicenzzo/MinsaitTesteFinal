package com.minsait.financas.testefinalfinancas.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.minsait.financas.testefinalfinancas.enums.RelacionamentoE;

@Entity
public class Emprestimo{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long CPFCliente;
	private BigDecimal valorIncial;
	private BigDecimal valorFinal;
	private RelacionamentoE relacionamento;
	private Integer dataInicial;
	private Integer dataFinal;
	
	
	
	public Emprestimo() {
		
	}

	public Emprestimo(BigDecimal valorIncial, BigDecimal valorFinal, RelacionamentoE relacionamento,Long CPFCliente, Integer dataInicial, Integer dataFinal) {
		this.valorIncial = valorIncial;
		this.valorFinal = valorFinal;
		this.relacionamento = relacionamento;
		this.CPFCliente = CPFCliente;
		this.dataInicial = dataInicial;
		this.dataFinal = dataFinal;
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

	public RelacionamentoE getRelacionamento() {
		return relacionamento;
	}

	public void setRelacionamento(RelacionamentoE relacionamento) {
		this.relacionamento = relacionamento;
	}
	public Long getCPFCliente() {
		return CPFCliente;
	}
	public void setCPFCliente(Long clienteRetorno) {
		this.CPFCliente = clienteRetorno;
	}
	public Integer getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Integer dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Integer getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Integer dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	
	
}
