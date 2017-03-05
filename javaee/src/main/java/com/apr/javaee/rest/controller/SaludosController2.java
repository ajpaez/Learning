package com.apr.javaee.rest.controller;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.apr.javaee.beans.stateless.CalculatorBean;

@Path("saludos")
@Produces({ "text/xml", "application/json" })
public class SaludosController2 {

	@Inject
	private CalculatorBean calculatorBean;

	@GET
	@Path("hola")
	public String message() {
		System.out.println(calculatorBean.add(1, 3));
		return "Hi REST @GET!";
	}

	@GET
	@Path("hola-{name : \\w+}")
	public String messageName(@DefaultValue("John Doe") @PathParam("name") String name) {
		System.out.println(calculatorBean.add(1, 3));
		return "Hi " + name + " REST @GET!";
	}

	@POST
	@Path("hola")
	public String lowerCase(final String message) {
		return "Hi REST @POST!".toLowerCase();
	}

}
