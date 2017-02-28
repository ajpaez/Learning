package com.apr.javaee.cdi.produces;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import com.apr.javaee.cdi.produces.impl.ConsoleHandler;
import com.apr.javaee.cdi.produces.impl.DatabaseHandler;
import com.apr.javaee.cdi.produces.impl.FileHandler;
import com.apr.javaee.cdi.produces.impl.LogHandler;

@RequestScoped
public class LogFactory implements Serializable {

	private static final long serialVersionUID = 2306537725217628063L;

	@Produces
	@LoggerType(LoggerTypeEnum.DB)
	public LogHandler getLoggerDb() {
		return new DatabaseHandler("@Produces created DatabaseHandler!");
	}

	@Produces
	@LoggerType(LoggerTypeEnum.FILE)
	public LogHandler getLoggerFile() {
		return new FileHandler("@Produces created FileHandler!");
	}

	@Produces
	@LoggerType(LoggerTypeEnum.CONSOLE)
	public LogHandler getLoggerConsole() {
		return new ConsoleHandler("@Produces created ConsoleHandler!");
	}

	// TODO: revisar porque no funciona
	public void closeLogger(@Disposes LogHandler logger) {
		logger.close();
	}

}
