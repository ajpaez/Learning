package com.apr.javaee.rest.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.apr.javaee.beans.stateless.CalculatorBean;

@Path("saludos")
@Produces({ "text/xml", "application/json" })
public class SaludosController {

	@Inject
	private CalculatorBean calculatorBean;

	@GET
	@Path("hola")
	public String message() {
		System.out.println(calculatorBean.add(1, 3));
		return "Hi REST @GET!";
	}

	@POST
	@Path("hola")
	public String lowerCase(final String message) {
		return "Hi REST @POST!".toLowerCase();
	}

}
