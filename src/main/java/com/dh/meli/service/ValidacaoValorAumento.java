package com.dh.meli.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.dh.meli.entity.Funcionario;
import com.dh.meli.entity.ValidacaoException;

public class ValidacaoValorAumento implements ValidacaoAumento{

	public void validar(Funcionario funcionario, BigDecimal valor) {
		BigDecimal percentualReajuste = valor.divide(funcionario.getDadosPessoais().getSalario(), RoundingMode.HALF_UP);
		if(percentualReajuste.compareTo(new BigDecimal(0.2))>0) {
			throw new ValidacaoException("Reajuste nao pode ser superior a 40% do salário");
		}
	}
}
