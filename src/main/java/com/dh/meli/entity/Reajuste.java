package com.dh.meli.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reajuste {

	private BigDecimal valor;
	private LocalDate dataReajuste;
	
	public Reajuste(BigDecimal valor, LocalDate dataReajuste) {
		super();
		this.valor = valor;
		this.dataReajuste = dataReajuste;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getDataReajuste() {
		return dataReajuste;
	}
}
