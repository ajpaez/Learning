package com.apr.javaee.cdi.requestscoped;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.junit.Test;

import com.apr.javaee.TestBase;

public class WaiterTest extends TestBase {

	private static final String TOMATO_SOUP = "Tomato Soup";
	private static final String POTATO_SOUP = "Potato Soup";
	private static final String SOUP_DAY = "Soup of the day";

	@EJB(name = "WaiterRS")
	private Waiter joe;

	@Inject
	private Soup soupTest;

	@Test
	public void orderSoup() {

		assertEquals(SOUP_DAY, joe.getSoupOfDay());

		String soup = joe.orderSoup(TOMATO_SOUP);
		assertEquals(TOMATO_SOUP, soup);
		soup = joe.orderSoup(POTATO_SOUP);
		assertEquals(POTATO_SOUP, soup);

		assertNotEquals(SOUP_DAY, joe.getSoupOfDay());

		assertTrue(joe.getSoup() == soupTest);

		assertTrue(joe.getChef().getSoup() == soupTest);
	}

}
