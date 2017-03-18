package com.apr.javaee.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.apr.javaee.rest.controller.SaludosControllerServices;

@ApplicationPath("/services")
// http://localhost:8080/javaee/services?_wadl
public class MiApplicationAnotada extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public MiApplicationAnotada() {
		// singletons.add(new CustomerResource());
		classes.add(SaludosControllerServices.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
