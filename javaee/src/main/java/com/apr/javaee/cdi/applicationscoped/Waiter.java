package com.apr.javaee.cdi.applicationscoped;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless(name = "WaiterAS")
public class Waiter {

	@Inject
	public Soup soup;

	public String orderSoup(String name) {
		soup.setName(name);
		return soup.getName();
	}

	public String orderWhatTheOtherGuyHad() {
		String name = soup.getName();
		return name;
	}
}
