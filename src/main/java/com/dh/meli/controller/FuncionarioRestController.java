package com.dh.meli.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dh.meli.dto.FuncionarioDTO;
import com.dh.meli.entity.Funcionario;
import com.dh.meli.service.FuncionarioService;

@RestController
@RequestMapping("/api")
//@Profile(value = {"prod", "test"})
public class FuncionarioRestController {

	@Autowired
	private FuncionarioService service;
	
	@PostMapping("/funcionario")
	public ResponseEntity<FuncionarioDTO> cadastraFuncionario(@RequestBody @Valid FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder) {
		Funcionario funcionario = FuncionarioDTO.converte(funcionarioDTO);
		service.cadastra(funcionario);
		URI uri = uriBuilder.path("/funcionario/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(FuncionarioDTO.converte(funcionario));
	}
	
	@GetMapping("/funcionario/{id}")
	public ResponseEntity<FuncionarioDTO> getFuncionario(@PathVariable Long id){
		Funcionario funcionario = service.get(id);
		return ResponseEntity.ok(FuncionarioDTO.converte(funcionario));
	}
	
	@GetMapping("/funcionarios")
	public ResponseEntity<List<FuncionarioDTO>> listaFuncionarios(){
		List<Funcionario> funcionarios = service.lista();
		List<FuncionarioDTO> funcionariosDTO = FuncionarioDTO.converte(funcionarios);
		return ResponseEntity.ok(funcionariosDTO);
	}
}
