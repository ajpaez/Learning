package com.apr.javaee.beans.stateful;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.naming.NamingException;

import org.junit.Test;

import com.apr.javaee.TestBase;

public class CounterTest extends TestBase {

	@Test
	public void test() throws NamingException {
		Counter counterA = (Counter) context.lookup("java:global/javaee/Counter");

		assertEquals(0, counterA.count());
		assertEquals(0, counterA.reset());
		assertEquals(1, counterA.increment());
		assertEquals(2, counterA.increment());
		assertEquals(0, counterA.reset());

		counterA.increment();
		counterA.increment();
		counterA.increment();
		counterA.increment();

		assertEquals(4, counterA.count());

		// Get a new counter
		Counter counterB = (Counter) context.lookup("java:global/javaee/Counter");

		// The new bean instance starts out at 0
		assertEquals(0, counterB.count());

		// Compare counter
		assertNotEquals(counterA, counterB);

		// compare count
		assertNotEquals(counterA.count(), counterB.count());
	}

}
