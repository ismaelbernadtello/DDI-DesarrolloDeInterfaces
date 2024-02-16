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

class StudentControllerTest {
	
	//Al ponerlo, spring se encarga de inyectar la dependencia, es decir, de instanciar el objeto
	StudentController controller;

	//@Mock -> Indica que es un mock, es un objeto simulado que imita el comportamiento de un objeto real.
	//Esto permite simular el comportamiento de StudentService sin tener que instanciar un objeto real de esa clase,
	
	@Mock
	private StudentService service;

	
	private List<Student> createMockedList() { //Función que devuelve una lista de estudiantes precreada
		List<Student> listaPrecreada = new ArrayList<Student>();
		listaPrecreada.add(new Student(1, "ignacio", "bielsa"));
		listaPrecreada.add(new Student(2, "alejandro", "tesan"));
		return listaPrecreada;
	}
	
	@Test
	void testInsertarEstudiante() {
		// given
		Model model = new ExtendedModelMap();
		Student student = new Student(); //Creamos un estudiante

		when(service.insertStudent(student)).thenReturn(createMockedList());
		//Este When es la abreviación de poner MOckito.when, no hay que ponerlo entero porque importa esto: import static org.mockito.Mockito.when;
		//Lo que hace esta función es que cuando se llama al método que le digamos, se devuelva una serie de datos preprogramados. 
		
		//En este caso en el return pone la función createMockedList, porque gorka quiso refactorizar el código y ponerlo dentro de una función. 
		//Pero lo que hace es crear una lista de estudiantes con 2 estudiantes por defecto y los devuelve.
		
		
		// when
		String finPage = controller.insertarEstudiante(student, model);
		
		// then
		assertEquals("fin", finPage); 
		//Comprobamos si la llamada a la función insertarEstudiante devuelve fin. 
		//fin es la vista a la que se nos redirige si el estudiante se ha creado correctamente
		
		
		//Comprueba que la lista de estudiantes que se devuelve al ir a la vista no es nula
		assertNotNull(model.getAttribute("estudiantes")); 
		assertInstanceOf(List.class, model.getAttribute("estudiantes"));//Comprobamos que estudiantes es un objeto de la clase list

		//Comprobamos que la lista no está vacía. La respuesta de lista.isEmpty() es falso y por lo tanto se cumple el assertFalse
		List<Student> lista = (List<Student>) model.getAttribute("estudiantes");
		assertFalse(lista.isEmpty());

	}

	
	@Test
	void testBorrarEstudiante() {
		// given
		Model model = new ExtendedModelMap();
		Student student = new Student();
		student.setId(1);
		
		//Preprogramamos que cuando se llame a la función deleteStudent con el id del estudiante, se devuelva una lista de estudiantes precreada.
		when(service.deleteStudent(student.getId())).thenReturn(createMockedList());
		
		// when
		String finPage = controller.borrarEstudiante(student.getId(), model); //Almacenamos la pagina a la que nos redirige
		
		// then
		assertEquals("fin", finPage); //Comprobamos que la página a la que nos redirige es fin
		
		assertNotNull(model.getAttribute("estudiantes")); //Se comprueba que la lista de estudiantes no es nula
		assertInstanceOf(List.class, model.getAttribute("estudiantes")); //Se comprueba que la lista de estudiantes es de la clase List
		List<Student> lista = (List<Student>) model.getAttribute("estudiantes"); //Se guarda la lista de estudiantes en una variable
		assertFalse(lista.isEmpty()); // Se comprueba que la lista de estudiantes no está vacía
	}
	
	
	@Test
	void testBuscarEstudiantes(){
		//given
		Model model = new ExtendedModelMap();
		String userInput = "ignacio";
		
		//Preprogramamos que cuando se llame a la función buscarEstudiantes, se devuelva una lista de estudiantes precreada.
		when(service.searchStudent(userInput)).thenReturn(createMockedList());
		
		//when
		String finPage = controller.buscarEstudiantes(userInput, model);
		
		//then
		assertEquals("fin", finPage); //Comprobamos que la página a la que nos redirige es fin
		
		assertNotNull(model.getAttribute("estudiantes")); //Se comprueba que la lista de estudiantes no es nula
		assertInstanceOf(List.class, model.getAttribute("estudiantes")); //Se comprueba que la lista de estudiantes es de la clase List
		List<Student> lista = (List<Student>) model.getAttribute("estudiantes"); //Se guarda la lista de estudiantes en una variable
		assertFalse(lista.isEmpty()); // Se comprueba que la lista de estudiantes no está vacía
	}
	
	
	@Test 
	void testActualizarEstudiante() {
		// given
		Model model = new ExtendedModelMap();
		Integer id = 1;
		Student student = new Student();
		student.setId(id);

		// Preprogramamos que cuando se llame a la función updateStudentList con el id
		// del estudiante, se devuelva un estudiante precreado.
		when(service.updateStudentList(id)).thenReturn(student);

		// when
		String finPage = controller.actualizarEstudiante(id, model); // Almacenamos la pagina a la que nos redirige

		// then
		assertEquals("index", finPage); // Comprobamos que la página a la que nos redirige es index

		assertNotNull(model.getAttribute("student")); // Se comprueba que el estudiante no es nulo
		assertInstanceOf(Student.class, model.getAttribute("student")); // Se comprueba que el estudiante es de la clase
																		// Student
		Student stud = (Student) model.getAttribute("student"); // Se guarda el estudiante en una variable
		assertEquals(id, stud.getId()); // Se comprueba que el id del estudiante es el mismo que el que hemos pasado
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
