package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.web.servlet.ModelAndView;

//importa todos los métodos estáticos de la clase, para no tener que poner el nombre de la clase cada vez que se quiera usar un método estático
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; 

@SpringBootTest 
@AutoConfigureMockMvc
class StudentControllerTest2 { //ESTA CLASE ES EN REALIDAD UN TEST DE LA APLICACIÓN, PODRIAMOS DECIR QUE ES UN TEST DE INTEGRACIÓN. PODRIAMOS LLAMARLA TEST DE LA APLICACIÓN

//	@Autowired
//	StudentController controller;

	@Autowired
	MockMvc mockmvc;

	@Test
	void testInsertStudentForm() {
		//Esto es como hacer una petición GET a la url /insertStudent pasandole los parametros nombre y apellido para que se cree un nuevo estudiante
		//Es lo que hacemos con POSTMAN, pero en este caso lo hacemos con código
		MockHttpServletRequestBuilder requestBuilder = get("/insertStudent")
														.queryParam("nombre", "Fernando")
														.queryParam("apellido", "Del Pino");
		
		try {
			//HAY QUE FIJARSE EN EL IMPORT DE MockMvcRequestBuilders, ESTÁ PUESTO EN ESTÁTICO PARA NO TENER QUE PONER EL NOMBRE DE LA CLASE CADA VEZ QUE SE QUIERA USAR UN MÉTODO ESTÁTICO
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn(); //andReturn() es para que devuelva el resultado de la petición
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("fin", modelAndView.getViewName());
			assertNotNull(modelAndView.getModel().get("estudiantes"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("No deberia producirse una excepcion");
		}
	}
	
	@Test
	void testDeleteStudentForm() {
		//Esto es como hacer una petición GET a la url /insertStudent pasandole los parametros nombre y apellido para que se cree un nuevo estudiante
		//Es lo que hacemos con POSTMAN, pero en este caso lo hacemos con código
		MockHttpServletRequestBuilder requestBuilder = get("/deleteStudent/{id}", 1); // le paso un path variable en este caso el id del estudiante a borrar
		
		try {
			//HAY QUE FIJARSE EN EL IMPORT DE MockMvcRequestBuilders, ESTÁ PUESTO EN ESTÁTICO PARA NO TENER QUE PONER EL NOMBRE DE LA CLASE CADA VEZ QUE SE QUIERA USAR UN MÉTODO ESTÁTICO
			MvcResult mvcResult = mockmvc.perform(requestBuilder).andExpect(status().isOk()).andReturn(); //andReturn() es para que devuelva el resultado de la petición
			ModelAndView modelAndView = mvcResult.getModelAndView();
			assertEquals("fin", modelAndView.getViewName());
			assertNotNull(modelAndView.getModel().get("estudiantes"));
		} catch (Exception e) {
			e.printStackTrace();
			fail("No deberia producirse una excepcion");
		}
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
