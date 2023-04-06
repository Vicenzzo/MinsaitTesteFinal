package com.minsait.financas.testefinalfinancas.dto;

import java.math.BigDecimal;

import com.minsait.financas.testefinalfinancas.entity.Cliente;

public class ClienteDTO {
	private String tel;
	private String cep;
	private String rua;
	private int numeroDaResidencia;
	private BigDecimal rendimentoMensal;
	
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(String tel, String cep, String rua, int numeroDaResidencia, BigDecimal rendimentoMensal) {
		super();
		this.tel = tel;
		this.cep = cep;
		this.rua = rua;
		this.numeroDaResidencia = numeroDaResidencia;
		this.rendimentoMensal = rendimentoMensal;
	}

	public static ClienteDTO retornarCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getTel(), cliente.getCEP(), cliente.getRua(), cliente.getNumeroDaResidencia(), cliente.getRendimentoMensal());
		return clienteDTO;
	}
	public static Cliente retornarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getTel(), clienteDTO.getCep(), clienteDTO.getRua(), clienteDTO.getNumeroDaResidencia(), clienteDTO.getRendimentoMensal());
		return cliente;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
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
