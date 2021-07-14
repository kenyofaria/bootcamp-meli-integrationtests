package com.dh.meli.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class DadosPessoais {

	private String nome;
	@Enumerated(EnumType.STRING)
	private Cargo cargo;
	private BigDecimal salario;
	private LocalDate dataEntrada;

	public DadosPessoais(String nome, Cargo cargo, BigDecimal salario, LocalDate dataEntrada) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.dataEntrada = dataEntrada;
	}

	public DadosPessoais() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

}
