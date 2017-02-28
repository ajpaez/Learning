package com.apr.javaee.cdi.applicationscoped;

import static org.junit.Assert.assertEquals;

import javax.ejb.EJB;

import org.junit.Test;

import com.apr.javaee.TestBase;

public class WaiterTest extends TestBase {

	private static String TOMATO_SOUP = "Tomato Soup";

	@EJB(name = "WaiterAS")
	private Waiter joe;

	@EJB
	private Waiter joeJunior;

	@Test
	public void orderSoup() {
		String someSoup = joe.orderSoup(TOMATO_SOUP);
		assertEquals(TOMATO_SOUP, someSoup);

		String sameSoup = joe.orderWhatTheOtherGuyHad();
		assertEquals(TOMATO_SOUP, sameSoup);

		joeJunior.orderWhatTheOtherGuyHad();

		assertEquals(TOMATO_SOUP, joeJunior.orderWhatTheOtherGuyHad());
	}

}
