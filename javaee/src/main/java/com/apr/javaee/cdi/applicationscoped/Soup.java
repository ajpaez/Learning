package com.apr.javaee.cdi.applicationscoped;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Soup {

	private String name = "Soup of the day";

	@PostConstruct
	public void afterCreate() {
		System.out.println("Soup ApplicationScoped created");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
