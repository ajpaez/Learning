package com.apr.javaee.rest.apiversioning.v1.dto;

public class Cliente {

	String nombre;
	String apellido1;
	String appelido2;

	public Cliente(String nombre, String apellido1) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getAppelido2() {
		return appelido2;
	}

	public void setAppelido2(String appelido2) {
		this.appelido2 = appelido2;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido1=" + apellido1 + ", appelido2=" + appelido2 + "]";
	}

}
