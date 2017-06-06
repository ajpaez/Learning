package com.apr.javaee.cdi.inject.concurrent;

import javax.ejb.Stateless;

@Stateless
public class ServiceInject {

	public void sayHello(String name) {
		System.out.println("Hi, I'm a thread name: " + name + " id: " + Thread.currentThread().getId());
	}
}
