package com.apr.javaee;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;

import org.junit.After;
import org.junit.Before;

public class TestBase {

	public static EJBContainer ejbContainer = null;
	public static Context context = null;

	@Before
	public void setUp() throws Exception {
		ejbContainer = EJBContainer.createEJBContainer();
		context = ejbContainer.getContext();
		context.bind("inject", this);
	}

	@After
	public void closeContainer2() throws Exception {
		context.unbind("inject");
		context.close();
		ejbContainer.close();
	}

}
