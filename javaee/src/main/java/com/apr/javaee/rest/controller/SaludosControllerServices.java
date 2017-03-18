package com.apr.javaee.rest.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("saludos") // <- Root Resource
public class SaludosControllerServices {

	@GET
	@Path("hola")
	public String message() {
		return "Hi REST @GETin /services!";
	}

	@GET
	@Path("context")
	public String contextTest(@Context final UriInfo uriInfo) {
		return uriInfo.getPath();
	}

	@GET
	@Path("response/{status}")
	public Response responseTest(@PathParam("status") Short status) {
		// http://docs.oracle.com/javaee/6/api/javax/ws/rs/core/Response.Status.html#ACCEPTED
		Response response = Response.status(Response.Status.OK).build();
		switch (status) {
		case 415:
			response = Response.status(Response.Status.UNSUPPORTED_MEDIA_TYPE).build();
			break;
		case 202:
			response = Response.status(Response.Status.ACCEPTED).build();
			break;
		case 500:
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
			break;
		case 404:
			response = Response.status(Response.Status.NOT_FOUND).build();
			break;

		default:
			throw new WebApplicationException(Response.Status.BAD_GATEWAY);
		}
		return response;
	}

}
