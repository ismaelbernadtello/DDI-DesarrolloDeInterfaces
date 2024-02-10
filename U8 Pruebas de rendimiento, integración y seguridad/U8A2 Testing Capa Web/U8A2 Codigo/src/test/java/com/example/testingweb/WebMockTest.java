package com.example.testingweb;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GreetingController.class)
class WebMockTest {

	@Autowired
	private MockMvc mockMvc; 

	@MockBean
	private GreetingService service;

	@Test
	void greetingShouldReturnMessageFromService() throws Exception {
		when(service.greet()).thenReturn("Hello, Mock"); // Hacemos un mock del servicio, para que cuando se llame a greet() devuelva "Hello, Mock"
		this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk()) // Hacemos una petición GET a /greeting y esperamos que el estado sea 200
				.andExpect(content().string(containsString("Hello, Mock"))); // Esperamos que el contenido de la respuesta contenga "Hello, Mock"
	}
}
