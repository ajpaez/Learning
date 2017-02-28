package com.apr.javaee.cdi.interceptor;

import javax.ejb.EJB;

import org.junit.Test;

import com.apr.javaee.TestBase;

public class BookShowTest extends TestBase {

	@EJB
	private BookShow bookForAShowBean;

	/**
	 * Test basic interception
	 */
	@Test
	public void testMethodShouldBeIntercepted() {

		bookForAShowBean.getMoviesList();

	}

}
