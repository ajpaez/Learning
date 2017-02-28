package com.apr.javaee.beans.singleton;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.ejb.AccessTimeout;
import javax.ejb.Asynchronous;
import javax.ejb.Lock;
import javax.ejb.Singleton;

@Singleton
@Lock(READ)
public class ComponentRegistry {

	CountDownLatch ready;

	private final Map<Class, Object> components = new HashMap<Class, Object>();

	public <T> T getComponent(final Class<T> type) {
		return (T) components.get(type);
	}

	public Collection<?> getComponents() {
		return new ArrayList(components.values());
	}

	@Lock(WRITE)
	public <T> T setComponent(final Class<T> type, final T value) {
		return (T) components.put(type, value);
	}

	@Lock(WRITE)
	public <T> T removeComponent(final Class<T> type) {
		return (T) components.remove(type);
	}

	@Lock(WRITE)
	@AccessTimeout(value = 2, unit = TimeUnit.SECONDS)
	public void doItSoon() {
	}

	@Asynchronous
	public Future stayBusy(CountDownLatch readyOut) {
		readyOut.countDown();

		try {
			this.ready = new CountDownLatch(1);
			this.ready.await();
		} catch (InterruptedException e) {
			Thread.interrupted();
		}

		return null;
	}

	public CountDownLatch getReady() {
		return this.ready;
	}

}
