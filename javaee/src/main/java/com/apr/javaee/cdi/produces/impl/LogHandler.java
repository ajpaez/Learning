package com.apr.javaee.cdi.produces.impl;

public interface LogHandler {

	public String getName();

	public void writeLog(String s);

	public String getLineLog(String s);

	public void close();

}
