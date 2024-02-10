package com.example.testingweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) // Esta anotación indica que se debe inicializar el servidor web con un puerto aleatorio
class HttpRequestTest {

	@LocalServerPort
	private int port; // Este atributo se inicializa con el puerto aleatorio que se asigna a la aplicación

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void greetingShouldReturnDefaultMessage() throws Exception { // Este test verifica que la aplicación responda correctamente
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
				String.class)).contains("Hello, World"); // Se verifica que la aplicación responda con el mensaje "Hello, World"
	}
}
