package com.apr.javaee.rest.apiversioning.pseudocore.factory;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.apr.javaee.rest.apiversioning.pseudocore.service.ClienteServices;

public class ClienteServicesFactory {

	@Inject
	Instance<ClienteServices> availableClientesService;

	public ClienteServices createService(String ver) {

		for (ClienteServices cs : availableClientesService) {
			if (cs.getVersion().equals(ver)) { // or whatever test you need
				return cs;
			}
		}
		return null;
	}

}
