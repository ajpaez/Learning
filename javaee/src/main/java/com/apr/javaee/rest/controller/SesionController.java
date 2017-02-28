package com.apr.javaee.rest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

@Path("login")
@Produces({ "text/xml", "application/json" })
public class SesionController {

	@Context
	private HttpServletRequest httpRequest;

	@POST
	@Path("do")
	public String lowerCase() {

		// get request parameters for userID and password
		String user = httpRequest.getParameter("user");
		String pwd = httpRequest.getParameter("pwd");

		return "Hi REST @POST!".toLowerCase();
	}

}
