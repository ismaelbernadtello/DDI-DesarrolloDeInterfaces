package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@ExtendWith(MockitoExtension.class) //Indica que usamos mockito, es necesario para usar la anotación @Mock
@SpringBootTest
class StudentControllerTest3 {
	@Autowired //Al ponerlo, spring se encarga de inyectar la dependencia, es decir, de instanciar el objeto
	StudentController controller;

	
	//@Mock -> Indica que es un mock, es un objeto simulado que imita el comportamiento de un objeto real.
	//Esto permite simular el comportamiento de StudentService sin tener que instanciar un objeto real de esa clase,
	
	@Autowired
	private StudentService service;
	
	//ESTE TEST ESTA HECHO PARA COMPROBAR QUE REALMENTE SE INSERTA UN ESTUDIANTE EN LA BASE DE DATOS Y SE BUSCA CORRECTAMENTE
	//SE USAN OBJETOS REALES Y NO MOCKS

	@Test
	void testBuscarEstudiantes(){
		//given
		Model model = new ExtendedModelMap();
		Student estudiante = new Student();
		estudiante.setId(1);
		estudiante.setNombre("ignacio");
		estudiante.setApellido("bielsa");
		
		//Preprogramamos que cuando se llame a la función buscarEstudiantes, se devuelva una lista de estudiantes precreada.
		//when(service.searchStudent(userInput)).thenReturn(createMockedList());
		
		//when
		List<Student> listaEstudiantes = service.insertStudent(estudiante);
		System.out.println(listaEstudiantes);
		String finPage = controller.buscarEstudiantes(estudiante.getNombre(), model);
		
		//then
		assertEquals("fin", finPage); //Comprobamos que la página a la que nos redirige es fin
		
		assertNotNull(model.getAttribute("estudiantes")); //Se comprueba que la lista de estudiantes no es nula
		assertInstanceOf(List.class, model.getAttribute("estudiantes")); //Se comprueba que la lista de estudiantes es de la clase List
		List<Student> lista = (List<Student>) model.getAttribute("estudiantes"); //Se guarda la lista de estudiantes en una variable
		System.out.println(lista);
		assertFalse(lista.isEmpty()); // Se comprueba que la lista de estudiantes no está vacía
	}
	
	private List<Student> createMockedList() { //Función que devuelve una lista de estudiantes precreada
		List<Student> listaPrecreada = new ArrayList<Student>();
		listaPrecreada.add(new Student(1, "ignacio", "bielsa"));
		listaPrecreada.add(new Student(2, "alejandro", "tesan"));
		return listaPrecreada;
	}
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		controller = new StudentController();
		controller.setService(service);

	}

	@AfterEach
	void tearDown() throws Exception {
	}

}
