package com.apr.javaee.cdi.requestscoped;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class Chef {

	@Inject
	private Soup soup;

	public Soup prepareSoup() {
		return soup;
	}

	public Soup getSoup() {
		return soup;
	}
}
