package com.apr.javaee.rest.controller;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apr.javaee.beans.stateless.CalculatorBean;
import com.apr.javaee.rest.model.Car;

//rest
@Path("saludos") // <- Root Resource
public class SaludosController {

	@Inject
	private CalculatorBean calculatorBean;

	@GET
	@Path("hola")
	public Response messageGet() {
		System.out.println(calculatorBean.add(1, 3));
		return Response.status(Response.Status.OK).entity(new String("Hi REST @GET!")).build();
	}

	@GET
	@Path("car")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response car() {
		return Response.status(Response.Status.OK).entity(new Car("5", "3")).build();
	}

	@POST
	@Path("hola")
	public String messagePost(final String message) {
		return "Hi REST @POST!".toLowerCase();
	}

	@GET
	@Path("hola-{name : \\w+}")
	public String messageName(@DefaultValue("John Doe") @PathParam("name") String name) {
		System.out.println(calculatorBean.add(1, 3));
		return "Hi " + name + " REST @GET!";
	}

	@GET
	@Path("name")
	public String messageNameMandatory(@NotNull @PathParam("name") String name) {
		return "Hi " + name + " REST @GET!";
	}

}
