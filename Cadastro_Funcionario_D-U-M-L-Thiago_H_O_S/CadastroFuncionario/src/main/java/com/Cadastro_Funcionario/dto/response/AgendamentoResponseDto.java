package com.Cadastro_Funcionario.dto.response;

import java.time.LocalDateTime;

import com.Cadastro_Funcionario.dto.*;

public class AgendamentoResponseDto {
	private Long id;
	
	private LocalDateTime dataHora;
	
	private ClienteDto cliente;
	
	private ServicoDto servico;

}
