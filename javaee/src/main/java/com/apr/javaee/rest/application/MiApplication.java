package com.apr.javaee.rest.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.apr.javaee.rest.controller.SaludosController;
import com.apr.javaee.rest.controller.SesionController;

public class MiApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> s = new HashSet<Class<?>>();
		s.add(SaludosController.class);
		s.add(SesionController.class);
		return s;
	}
}
