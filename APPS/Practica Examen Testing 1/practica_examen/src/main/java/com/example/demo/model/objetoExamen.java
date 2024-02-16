package com.example.demo.model;

import java.util.Date;

import lombok.Data;

@Data // Esto es para que no tengamos que poner los getter y setter, lo hace lombok por nosotros
public class objetoExamen {
	private String nombre;
	private Integer numero1;
	private Integer numero2;
	private Date fecha;
	
	public objetoExamen(String nombre, Integer numero1, Integer numero2, Date fecha) {
		super();
		this.nombre = nombre;
		this.numero1 = numero1;
		this.numero2 = numero2;
		this.fecha = fecha;
	}
	
	public objetoExamen() {
	}
	
	//Preguntar si se puede volver a activar lombok y no tener que hacer a mano los getter y setter
}