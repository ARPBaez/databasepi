package com.vendas.app;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@DisplayName("Titulo do teste")
@TestInstance(Lifecycle.PER_CLASS)
public class TesteAppvendas extends AppApplicationTests {

	
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeAll
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		System.out.println("executa antes da classe all");	
	}
	
	
	@AfterAll
	public void tearDown()
	{
		System.out.println("executa depois da classe all");
		mockMvc=null;
	}
	
	@DisplayName("Teste das Rotas : ╯°□°）╯ 😱")
	@Test
	final void testCaminhos() throws Exception {
		System.out.println("executando teste de Rotas");
		mockMvc.perform(get("/")).andExpect(status().isOk());
		
		mockMvc.perform(get("/home")).andExpect(status().isOk());
		mockMvc.perform(get("/cliente")).andExpect(status().isOk());
		mockMvc.perform(get("/lista")).andExpect(status().isOk());
		mockMvc.perform(get("/deletarcliente/1")).andExpect(status().isOk());
		mockMvc.perform(get("/editarcliente/1")).andExpect(status().isOk());
		
		mockMvc.perform(post("/home")).andExpect(status().isOk());
		mockMvc.perform(post("/cliente")).andExpect(status().isOk());
		mockMvc.perform(post("/lista")).andExpect(status().isOk());
		mockMvc.perform(post("/deletarcliente/1")).andExpect(status().isOk());
		mockMvc.perform(post("/editarcliente/1")).andExpect(status().isOk());
		
		
	}
	
	
	}
