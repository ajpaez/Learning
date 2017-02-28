package com.apr.javaee.cdi.produces.impl;

public class DatabaseHandler implements LogHandler {

	private String name;

	public DatabaseHandler(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void writeLog(String s) {
		System.out.printf("##### Handler: %s, Writing to the database! " + s + "\n", getName());
		// Use connection to write log to database
	}

	@Override
	public String getLineLog(String s) {
		return "##### Handler: " + getName() + ", Writing to the database! " + s + "\n";
	}

	@Override
	public void close() {
		System.out.printf("##### Handler: %s, Close to the database! ", getName());
	}

}
