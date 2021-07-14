package com.dh.meli.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.meli.entity.Funcionario;
import com.dh.meli.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	private FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void cadastra(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> lista(){
		return this.funcionarioRepository.findAll();
	}

	public Funcionario get(Long id) {
		return this.funcionarioRepository.getById(id);
	}
}
