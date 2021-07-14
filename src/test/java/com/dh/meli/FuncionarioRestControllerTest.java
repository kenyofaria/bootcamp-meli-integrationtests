package com.dh.meli;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.dh.meli.dto.FuncionarioDTO;
import com.dh.meli.entity.Cargo;
import com.dh.meli.entity.Funcionario;
import com.dh.meli.repository.FuncionarioRepository;
import com.dh.meli.service.FuncionarioService;
import com.fasterxml.jackson.databind.ObjectMapper;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class FuncionarioRestControllerTest {

	
//	private FuncionarioRestController controller;

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	private FuncionarioService service;
	
	@Autowired
	private FuncionarioRepository repository;
	
	
//	@Test
//	public void contextLoads() throws Exception{
//		Assertions.assertThat(controller).isNotNull();
//	}
	
	@BeforeEach
	private void init() {
		repository.deleteAll();
	}
	
	@Test
	public void deve_CadastrarUmFuncionario() throws Exception {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO("Bruno", Cargo.ESPECIALISTA.toString(), new BigDecimal(20000), LocalDate.now());
		
		String payLoad = mapper.writeValueAsString(funcionarioDTO);
		mock.perform(post("/api/funcionario")
	            .contentType("application/json")
	            .content(payLoad))
	        .andExpect(status().isCreated());
	}
	
	private void efetuaCadastro() {
		FuncionarioDTO funcionarioDTO = new FuncionarioDTO("Kenyo", Cargo.ESPECIALISTA.toString(), new BigDecimal(20000), LocalDate.now());
		Funcionario funcionario = FuncionarioDTO.converte(funcionarioDTO);
		service.cadastra(funcionario);
	}
	
	@Test
	public void deve_ObjterUmFuncionario() throws Exception {
		efetuaCadastro();
		mock.perform(get("/api/funcionario/{id}", 1L))
	            .andExpect(status().isOk())
	            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	            .andExpect(jsonPath("$.nome").value("Kenyo"));
	}
	
}
