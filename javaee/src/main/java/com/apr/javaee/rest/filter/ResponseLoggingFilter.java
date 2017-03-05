package com.apr.javaee.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
@LoggingFilterBinding
public class ResponseLoggingFilter implements ContainerResponseFilter {

	@Override
	public void filter(final ContainerRequestContext paramContainerRequestContext,
			final ContainerResponseContext paramContainerResponseContext) throws IOException {
		System.out.println("ResponseLoggingFilter initialized");

	}

}
