package com.apr.javaee.cdi.inject.concurrent;

import javax.inject.Inject;

public class MyRunnable implements Runnable {

	@Inject
	ServiceInject service;

	String name;

	@Override
	public void run() {

		service.sayHello(name);

	}

	public void setName(String string) {
		this.name = string;

	}

}
