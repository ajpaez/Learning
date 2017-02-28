package com.apr.javaee.beans.stateless;

import javax.ejb.Stateless;

@Stateless
public class CalculatorBean {

	private int x;

	public int add(int a, int b) {
		return a + b;
	}

	public int subtract(int a, int b) {
		return a - b;
	}

	public int multiply(int a, int b) {
		return a * b;
	}

	public int divide(int a, int b) {
		return a / b;
	}

	public int remainder(int a, int b) {
		return a % b;
	}

	public void setX(int i) {
		this.x = i;
	}

	public int getX() {
		return this.x;
	}
}
