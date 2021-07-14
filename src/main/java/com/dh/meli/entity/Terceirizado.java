package com.dh.meli.entity;


public class Terceirizado{

	private String empresa;
	private DadosPessoais dadosPessoais;
	
	public Terceirizado(DadosPessoais dadosPessoais, String empresa) {
		this.dadosPessoais = dadosPessoais;
		this.empresa = empresa;
	}
	
	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	public String getEmpresa() {
		return empresa;
	}
}
