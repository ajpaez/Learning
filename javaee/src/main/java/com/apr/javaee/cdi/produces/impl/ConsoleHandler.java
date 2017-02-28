package com.apr.javaee.cdi.produces.impl;

public class ConsoleHandler implements LogHandler {

	private String name;

	public ConsoleHandler(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void writeLog(String s) {
		System.out.printf("##### Handler: %s, Writing to the console! " + s + "\n", getName());
	}

	@Override
	public String getLineLog(String s) {
		return "##### Handler: " + getName() + ", Writing to the console! " + s + "\n";
	}

	@Override
	public void close() {
		System.out.printf("##### Handler: %s, Close to the console! ", getName());
	}
}
