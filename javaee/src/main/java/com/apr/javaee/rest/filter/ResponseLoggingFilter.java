package com.apr.javaee.rest.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
@LoggingFilterBinding
@Priority(Priorities.USER)
public class ResponseLoggingFilter implements ContainerResponseFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext cres)
			throws IOException {

		/**
		 * When a REST web client is no longer on the same domain as the server
		 * that hosts the REST APIs, the REST response message header should
		 * have the Cross Origin Resource Sharing (CORS) header values set to
		 * the appropriate domain names, which are allowed to access the APIs.
		 */
		// Specify CORS headers: * represents allow all values

		cres.getHeaders().add("Access-Control-Allow-Origin", "*");
		cres.getHeaders().add("Access-Control-Allow-Headers", "*");
		cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
		cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		cres.getHeaders().add("Access-Control-Max-Age", "1209600");

		System.out.println("ResponseLoggingFilter implents ContainerResponseFilter initialized");

	}

}
