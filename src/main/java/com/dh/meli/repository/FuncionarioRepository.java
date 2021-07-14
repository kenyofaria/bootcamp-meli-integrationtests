package com.dh.meli.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dh.meli.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario getByDadosPessoais_Nome(String nome);
}
