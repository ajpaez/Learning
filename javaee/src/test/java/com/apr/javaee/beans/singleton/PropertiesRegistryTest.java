package com.apr.javaee.beans.singleton;

import org.junit.Assert;
import org.junit.Test;

import com.apr.javaee.TestBase;

public class PropertiesRegistryTest extends TestBase {

	@Test
	public void oneInstancePerMultipleReferences() throws Exception {

		final PropertyRegistry one = (PropertyRegistry) context.lookup("java:global/javaee/PropertyRegistry");
		final PropertyRegistry two = (PropertyRegistry) context.lookup("java:global/javaee/PropertyRegistry");

		Assert.assertNotNull(one);
		Assert.assertNotNull(two);

		one.setProperty("url", "http://superbiz.org");
		String url = two.getProperty("url");
		Assert.assertSame("http://superbiz.org", url);

		two.removeProperty("url");
		url = one.getProperty("url");
		Assert.assertNull(url);

		two.setProperty("version", "1.0.5");
		String version = one.getProperty("version");
		Assert.assertSame("1.0.5", version);

		one.removeProperty("version");
		version = two.getProperty("version");
		Assert.assertNull(version);
	}

}
