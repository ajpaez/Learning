package com.apr.javaee.cdi.produces.impl;

public class FileHandler implements LogHandler {

	private String name;

	public FileHandler(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void writeLog(String s) {
		System.out.printf("##### Handler: %s, Writing to the file! " + s + "\n", getName());
		// Write to log file
	}

	@Override
	public String getLineLog(String s) {
		return "##### Handler: " + getName() + ", Writing to the file! " + s + "\n";
	}

	@Override
	public void close() {
		System.out.printf("##### Handler: %s, Close to the file! ", getName());
	}

}
