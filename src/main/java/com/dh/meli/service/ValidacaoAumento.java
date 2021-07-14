package com.dh.meli.service;

import java.math.BigDecimal;

import com.dh.meli.entity.Funcionario;

public interface ValidacaoAumento {

	void validar(Funcionario funcionario, BigDecimal valor);
}
