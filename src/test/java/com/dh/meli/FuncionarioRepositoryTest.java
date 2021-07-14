package com.dh.meli;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.dh.meli.entity.Cargo;
import com.dh.meli.entity.DadosPessoais;
import com.dh.meli.entity.Funcionario;
import com.dh.meli.repository.FuncionarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
public class FuncionarioRepositoryTest {

	@Autowired
	private FuncionarioRepository repository;

	@BeforeEach
	public void init() {
		repository.deleteAll();
	}
	
	@Test
	public void deve_CarregarUmFuncionario_QuandoNomeFornecido() {
		efetuaCadastro();
		String nomeFuncionario = "Bruno";
		Funcionario funcionario = repository.getByDadosPessoais_Nome(nomeFuncionario);
		assertNotNull(funcionario);
		assertEquals(nomeFuncionario, funcionario.getDadosPessoais().getNome());
	}
	
	private void efetuaCadastro() {
		Funcionario funcionario = new Funcionario(new DadosPessoais("Bruno", Cargo.ANALISTA, new BigDecimal(5000), LocalDate.now()));
		repository.save(funcionario);
	}
}
