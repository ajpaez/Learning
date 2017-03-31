package com.apr.javaee.rest.apiversioning.pseudocore.v1.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import com.apr.javaee.rest.apiversioning.pseudocore.service.ClienteServices;
import com.apr.javaee.rest.apiversioning.pseudocore.v1.dto.Cliente;

public class ClienteServicesV1 implements ClienteServices {

	@Override
	public String getVersion() {
		return "v1";
	}

	@Override
	public List<String> getClientes() {
		List<String> clientes = new ArrayList<>();
		clientes.add(new Cliente("Jhon", "Doe").toString());
		return clientes;
	}

}
