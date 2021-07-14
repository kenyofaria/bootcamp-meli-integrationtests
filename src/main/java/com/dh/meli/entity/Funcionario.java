package com.dh.meli.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private DadosPessoais dadosPessoais;

	@Transient
	private List<Reajuste> reajustes;
	
	
	public Funcionario() {
	}

	
	public Funcionario(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
		initReajustes();
	}
	
	public Funcionario(DadosPessoais dadosPessoais, List<Reajuste> reajustes) {
		this.dadosPessoais = dadosPessoais;
		this.reajustes = reajustes;

	}
	
	private void initReajustes() {
		this.reajustes = new ArrayList<Reajuste>();
	}
	
	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	public BigDecimal getValorTotalEmReajustes(){
		BigDecimal total = this.reajustes.stream().map(r -> r.getValor()).reduce(new BigDecimal(0), BigDecimal::add);
		return total;
	}

	public Long getId() {
		return id;
	}
	public void reajustaSalario(BigDecimal aumento) {
		if(reajustes == null)
			initReajustes();
		reajustes.add(new Reajuste(aumento, LocalDate.now()));
		BigDecimal salarioAtual = this.dadosPessoais.getSalario();
		BigDecimal novoSalario = salarioAtual.add(aumento);
		this.dadosPessoais.setSalario(novoSalario);
	}

}
