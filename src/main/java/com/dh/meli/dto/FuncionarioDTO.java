package com.dh.meli.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Size;

import com.dh.meli.entity.Cargo;
import com.dh.meli.entity.DadosPessoais;
import com.dh.meli.entity.Funcionario;
import com.sun.istack.NotNull;

public class FuncionarioDTO {

	@NotNull
	@Size(min = 3)
	private String nome;
	private String cargo;
	private BigDecimal salario;
	private LocalDate dataEntrada;
	
	
	public FuncionarioDTO(String nome, String cargo, BigDecimal salario, LocalDate dataEntrada) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
	}
	public String getNome() {
		return nome;
	}
	public String getCargo() {
		return cargo;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	
	public static Funcionario converte(FuncionarioDTO dto) {
		DadosPessoais dados = new DadosPessoais(dto.getNome(), Cargo.valueOf(dto.getCargo().toUpperCase()), dto.getSalario(), dto.getDataEntrada());
		Funcionario funcionario = new Funcionario(dados);
		return funcionario;
	}
	
	public static List<FuncionarioDTO> converte(List<Funcionario> funcionarios) {
		
		List<FuncionarioDTO> lista = funcionarios.stream().map(f -> new FuncionarioDTO(f.getDadosPessoais().getNome(), 
														  f.getDadosPessoais().getCargo().toString(), 
														  f.getDadosPessoais().getSalario(), 
														  f.getDadosPessoais().getDataEntrada())).collect(Collectors.toList());
		return lista;
	}
	public static FuncionarioDTO converte(Funcionario funcionario) {
		
		return new FuncionarioDTO(funcionario.getDadosPessoais().getNome(), 
				funcionario.getDadosPessoais().getCargo().toString(), 
				funcionario.getDadosPessoais().getSalario(), 
				funcionario.getDadosPessoais().getDataEntrada());
	}
	
}
