package com.apr.javaee.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.apr.javaee.rest.filter.LoggingFilterBinding;

//rest
@Path("login")
public class SesionController {

	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("do")
	@LoggingFilterBinding
	public String lowerCase() {

		// get request parameters for userID and password
		final String user = httpRequest.getParameter("user");
		final String pwd = httpRequest.getParameter("pwd");

		System.out.println("user: " + user + " pwd: " + pwd);

		return "Hi REST @POST!".toLowerCase();
	}

}
