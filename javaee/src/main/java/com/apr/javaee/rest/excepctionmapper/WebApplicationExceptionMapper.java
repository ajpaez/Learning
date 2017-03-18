package com.apr.javaee.rest.excepctionmapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException> {

	@Override
	public Response toResponse(final WebApplicationException paramE) {
		System.out.println("WebApplicationExceptionMapper in action");

		return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
	}

}
