package com.apr.javaee.rest.apiversioning.controller;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apr.javaee.rest.apiversioning.pseudocore.factory.ClienteServicesFactory;
import com.apr.javaee.rest.apiversioning.pseudocore.service.ClienteServices;

@Stateless
@Path("/{ver}/clientes")
@Produces({ MediaType.APPLICATION_JSON })
public class ApiController {

	@Inject
	private ClienteServicesFactory clienteServiceFactory;

	@GET
	@Path("")
	public Response messageGet(@PathParam("ver") String ver) {

		ClienteServices clienteService = clienteServiceFactory.createService(ver);

		if (clienteService != null) {
			return Response.status(Response.Status.OK).entity(clienteService.getClientes()).build();
		} else {
			return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
		}

	}

}
