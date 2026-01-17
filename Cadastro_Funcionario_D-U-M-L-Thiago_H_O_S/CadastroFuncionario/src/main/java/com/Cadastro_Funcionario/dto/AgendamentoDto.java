package com.Cadastro_Funcionario.dto;

import java.time.LocalDateTime;

import org.hibernate.service.Service;

import com.Cadastro_Funcionario.model.Cliente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AgendamentoDto {
	
	private LocalDateTime dataHora;
	
	private Cliente cliente;
	
	private Service service;
	
	public AgendamentoDto () {}
	
	public AgendamentoDto(LocalDateTime dataHora, Cliente cliente, Service servico) {
		this.dataHora = dataHora;
		this.cliente = cliente;
		this.service = servico;
	}
	
}
