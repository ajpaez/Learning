package com.apr.javaee.rest.interceptor;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
public class JAXRSReaderInterceptor implements ReaderInterceptor {
	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		InputStream originalInputStream = context.getInputStream();

		return context.proceed();
	}

}
