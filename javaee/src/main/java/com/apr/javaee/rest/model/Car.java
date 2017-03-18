package com.apr.javaee.rest.model;

public class Car {

	String size;
	String dor;

	public Car(String size, String dor) {
		this.size = size;
		this.dor = dor;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getDor() {
		return dor;
	}

	public void setDor(String dor) {
		this.dor = dor;
	}

}
