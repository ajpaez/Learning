package com.apr.javaee.beans.singleton;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Test;

import com.apr.javaee.TestBase;

public class ComponentRegistryTest extends TestBase {

	@Test
	public void oneInstancePerMultipleReferences() throws NamingException, URISyntaxException {

		// Both references below will point to the exact same instance
		final ComponentRegistry one = (ComponentRegistry) context.lookup("java:global/javaee/ComponentRegistry");
		final ComponentRegistry two = (ComponentRegistry) context.lookup("java:global/javaee/ComponentRegistry");

		Assert.assertNotNull(one);
		Assert.assertNotNull(two);

		final URI expectedUri = new URI("foo://bar/baz");
		one.setComponent(URI.class, expectedUri);
		final URI actualUri = two.getComponent(URI.class);
		Assert.assertSame(expectedUri, actualUri);

		two.removeComponent(URI.class);
		URI uri = one.getComponent(URI.class);
		Assert.assertNull(uri);

		one.removeComponent(URI.class);
		uri = two.getComponent(URI.class);
		Assert.assertNull(uri);

		final Date expectedDate = new Date();
		two.setComponent(Date.class, expectedDate);
		final Date actualDate = one.getComponent(Date.class);
		Assert.assertSame(expectedDate, actualDate);

		Collection<?> collection = one.getComponents();
		System.out.println(collection);
		Assert.assertEquals("Reference 'one' - ComponentRegistry contains one record", collection.size(), 1);

		collection = two.getComponents();
		Assert.assertEquals("Reference 'two' - ComponentRegistry contains one record", collection.size(), 1);
	}

	@Test
	public void testAccessTimeout() throws NamingException, InterruptedException {
		CountDownLatch ready = new CountDownLatch(1);

		final ComponentRegistry one = (ComponentRegistry) context.lookup("java:global/javaee/ComponentRegistry");

		// This asynchronous method will never exit
		one.stayBusy(ready);

		// Are you working yet little bee?
		ready.await();

		{ // Timeout in 2 seconds
			final long start = System.nanoTime();

			try {
				one.doItSoon();
				fail("The bee should be busy");
			} catch (Exception e) {
				// the bee is still too busy as expected
				System.out.println(e.getMessage());

			}

			assertEquals(2, seconds(start));
			// desbloqueamos el hilo que mantiene ocupado el singleton
			one.getReady().countDown();
		}

	}

	private long seconds(long start) {
		return TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - start);
	}

}
