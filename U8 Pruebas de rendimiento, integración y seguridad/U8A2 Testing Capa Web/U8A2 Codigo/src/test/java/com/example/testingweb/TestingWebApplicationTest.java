package com.example.testingweb;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest //Indica que se debe inicializar el contexto de Spring para las pruebas
@AutoConfigureMockMvc //Con esta anotación se configura el entorno de pruebas para que se inicialice MockMvc
class TestingWebApplicationTest {

	@Autowired
	private MockMvc mockMvc; //MockMvc es una clase que permite realizar peticiones HTTP a la aplicación sin necesidad de iniciar un servidor web

	@Test
	void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk()) //Se realiza una petición GET a la aplicación y se verifica que la respuesta sea 200
				.andExpect(content().string(containsString("Hello, World"))); //Y se verifica que la respuesta contenga el mensaje "Hello, World"
	}
}
