package com.minsait.financas.testefinalfinancas.dto;

import java.math.BigDecimal;

import com.minsait.financas.testefinalfinancas.entity.Cliente;

public class ClienteDTO {
	private Integer telefone;
	private String cep;
	private String rua;
	private Integer numeroDaResidencia;
	private BigDecimal rendimentoMensal;
	
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Integer telefone, String cep, String rua, Integer numeroDaResidencia, BigDecimal rendimentoMensal) {
		super();
		this.telefone = telefone;
		this.cep = cep;
		this.rua = rua;
		this.numeroDaResidencia = numeroDaResidencia;
		this.rendimentoMensal = rendimentoMensal;
	}

	public static ClienteDTO retornarCliente(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO(cliente.getTelefone(), cliente.getCEP(), cliente.getRua(), cliente.getNumeroDaResidencia(), cliente.getRendimentoMensal());
		return clienteDTO;
	}
	public static Cliente retornarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO.getTelefone(), clienteDTO.getCep(), clienteDTO.getRua(), clienteDTO.getNumeroDaResidencia(), clienteDTO.getRendimentoMensal());
		return cliente;
	}
	public Integer getTelefone() {
		return telefone;
	}
	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
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
