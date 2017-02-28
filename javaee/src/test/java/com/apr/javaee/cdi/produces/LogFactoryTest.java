package com.apr.javaee.cdi.produces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.apr.javaee.TestBase;
import com.apr.javaee.cdi.produces.impl.ConsoleHandler;
import com.apr.javaee.cdi.produces.impl.DatabaseHandler;
import com.apr.javaee.cdi.produces.impl.FileHandler;
import com.apr.javaee.cdi.produces.impl.LogHandler;

public class LogFactoryTest extends TestBase {

	@Inject
	@LoggerType(LoggerTypeEnum.DB)
	private LogHandler loggerDB;

	@Inject
	@LoggerType(LoggerTypeEnum.FILE)
	private LogHandler loggerFile;

	@Inject
	@LoggerType(LoggerTypeEnum.CONSOLE)
	private LogHandler loggerConsole;

	@Test
	public void testLogHandler() {
		assertNotNull(loggerDB);
		assertNotNull(loggerFile);
		assertNotNull(loggerConsole);

		assertTrue("Handler should be a DatabaseHandler", loggerDB instanceof DatabaseHandler);
		assertTrue("Handler should be a FileHandler", loggerFile instanceof FileHandler);
		assertTrue("Handler should be a ConsoleHandler", loggerConsole instanceof ConsoleHandler);

		String lineLogDb = "##### Handler: " + loggerDB.getName() + ", Writing to the database! \n";
		String lineLogFile = "##### Handler: " + loggerFile.getName() + ", Writing to the file! \n";
		String lineLogConsole = "##### Handler: " + loggerConsole.getName() + ", Writing to the console! \n";

		assertEquals(loggerDB.getLineLog(""), lineLogDb);
		assertEquals(loggerFile.getLineLog(""), lineLogFile);
		assertEquals(loggerConsole.getLineLog(""), lineLogConsole);
	}

}
