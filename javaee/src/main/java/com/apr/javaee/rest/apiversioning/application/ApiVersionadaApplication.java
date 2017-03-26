package com.apr.javaee.rest.apiversioning.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.apr.javaee.rest.apiversioning.controller.ApiController;

@ApplicationPath("/api")
public class ApiVersionadaApplication extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public ApiVersionadaApplication() {
		classes.add(ApiController.class);
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
