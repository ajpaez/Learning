package com.apr.javaee.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.apr.javaee.rest.controller.AsyncController;
import com.apr.javaee.rest.controller.SaludosController;
import com.apr.javaee.rest.controller.SesionController;

@ApplicationPath("/rest")
// http://localhost:8080/javaee/rest?_wadl
public class MiApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public MiApplication() {
		classes.add(SaludosController.class);
		classes.add(SesionController.class);
		classes.add(AsyncController.class);
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
