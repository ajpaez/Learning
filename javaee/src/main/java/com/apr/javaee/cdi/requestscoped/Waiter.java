package com.apr.javaee.cdi.requestscoped;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless(name = "WaiterRS")
public class Waiter {

	@Inject
	private Soup soup;

	@EJB
	private Chef chef;

	public String orderSoup(String name) {
		soup.setName(name);
		return chef.prepareSoup().getName();
	}

	public String getSoupOfDay() {
		return soup.getName();
	}

	public Soup getSoup() {
		return soup;
	}

	public Chef getChef() {
		return chef;
	}
}
