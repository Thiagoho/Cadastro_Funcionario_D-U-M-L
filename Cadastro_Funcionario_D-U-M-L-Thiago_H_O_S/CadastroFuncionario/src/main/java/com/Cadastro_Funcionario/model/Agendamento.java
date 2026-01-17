package com.Cadastro_Funcionario.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
@Getter
@Setter


@Entity
@Table(name = "agendamentos")
public class Agendamento {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dataHora;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "servico_id")
	private Servico servico;
	
	public Agendamento() {}
	
	public Agendamento(LocalDateTime dataHora, Cliente cliente, Servico servico) {
		this.dataHora = dataHora;
		this.cliente = cliente;
		this.servico = servico;
	}
}
