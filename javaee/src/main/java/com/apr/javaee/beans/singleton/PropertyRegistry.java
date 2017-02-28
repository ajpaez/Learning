package com.apr.javaee.beans.singleton;

import static javax.ejb.ConcurrencyManagementType.BEAN;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
@ConcurrencyManagement(BEAN)
public class PropertyRegistry {

	// Note the java.util.Properties object is a thread-safe
	// collections that uses synchronization. If it didn't
	// you would have to use some form of synchronization
	// to ensure the PropertyRegistryBean is thread-safe.
	private final Properties properties = new Properties();

	// The @Startup annotation ensures that this method is
	// called when the application starts up.
	@PostConstruct
	public void applicationStartup() {
		properties.putAll(System.getProperties());
	}

	@PreDestroy
	public void applicationShutdown() {
		properties.clear();
	}

	public String getProperty(final String key) {
		return properties.getProperty(key);
	}

	public String setProperty(final String key, final String value) {
		return (String) properties.setProperty(key, value);
	}

	public String removeProperty(final String key) {
		return (String) properties.remove(key);
	}
}
