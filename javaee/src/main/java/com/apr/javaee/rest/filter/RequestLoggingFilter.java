package com.apr.javaee.rest.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
@LoggingFilterBinding
public class RequestLoggingFilter implements ContainerRequestFilter {

	@Override
	public void filter(final ContainerRequestContext paramContainerRequestContext) throws IOException {
		System.out.println("RequestLoggingFilter initialized");

	}
}
