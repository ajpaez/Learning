package com.apr.javaee.beans.stateless;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import com.apr.javaee.TestBase;

public class CalculatorBeanTest extends TestBase {

	private CalculatorBean calculator;

	@Before
	public void lookupABean() throws Exception {

		Object object = context.lookup("java:global/javaee/CalculatorBean");

		assertTrue(object instanceof CalculatorBean);

		calculator = (CalculatorBean) object;
	}

	/**
	 * Test Add method
	 */
	@Test
	public void testAdd() {

		assertEquals(10, calculator.add(4, 6));

	}

	/**
	 * Test Subtract method
	 */
	@Test
	public void testSubtract() {

		assertEquals(-2, calculator.subtract(4, 6));

	}

	/**
	 * Test Multiply method
	 */
	@Test
	public void testMultiply() {

		assertEquals(24, calculator.multiply(4, 6));

	}

	/**
	 * Test Divide method
	 */
	@Test
	public void testDivide() {

		assertEquals(2, calculator.divide(12, 6));

	}

	/**
	 * Test Remainder method
	 */
	@Test
	public void testRemainder() {

		assertEquals(4, calculator.remainder(46, 6));

	}

	@Test
	public void testGetInstances() throws NamingException {

		Object objectA = context.lookup("java:global/javaee/CalculatorBean");

		assertTrue(objectA instanceof CalculatorBean);

		CalculatorBean calculatorA = (CalculatorBean) objectA;
		calculatorA.setX(1);

		Object objectB = context.lookup("java:global/javaee/CalculatorBean");

		assertTrue(objectB instanceof CalculatorBean);

		CalculatorBean calculatorB = (CalculatorBean) objectB;
		calculatorB.setX(2);

		assertEquals(calculatorA.getX(), calculatorB.getX());

	}

}
