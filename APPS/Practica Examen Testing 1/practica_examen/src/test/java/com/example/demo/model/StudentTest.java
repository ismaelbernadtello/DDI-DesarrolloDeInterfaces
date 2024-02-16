package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {

	Student student;

	@Test
	void testGetApellidoWhenApellidoIsNotEmpty() {
		// when
		student = new Student(1, "juan", "apellaniz");

		// then
		assertEquals("apellaniz", student.getApellido());
	}

	@Test
	void testGetApellidoWhenApellidoIsEmpty() {
		// when
		student = new Student(1, "juan", null);

		// then
		assertEquals(null, student.getApellido());
	}

	@Test
	void testGetNombreWhenNombreIsNotEmpty() {
		// when
		student = new Student(1, "juan", "apellaniz");

		// then
		assertEquals("juan", student.getNombre());
	}
	
	@Test
	void testGetNombreWhenNombreIsEmpty() {
		// when
		student = new Student(1, null, "apellaniz");

		// then
		assertEquals(null, student.getNombre());
	}
	
	@Test
	void testGetIdWhenIdIsNotEmpty() {
		// when
		student = new Student(1, "juan", "apellaniz");

		// then
		assertEquals(1, student.getId());
	}
	
	@Test
	void testGetIdWhenIdIsEmpty() {
		// when
		student = new Student(0, "juan", "apellaniz");

		// then
		assertEquals(0, student.getId());
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
