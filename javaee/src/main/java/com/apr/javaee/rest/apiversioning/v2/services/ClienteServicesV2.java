package com.apr.javaee.rest.apiversioning.v2.services;

import java.util.ArrayList;
import java.util.List;

import com.apr.javaee.rest.apiversioning.services.ClienteServices;
import com.apr.javaee.rest.apiversioning.v2.dto.Cliente;

public class ClienteServicesV2 implements ClienteServices {

	@Override
	public String getVersion() {
		return "v2";
	}

	@Override
	public List<String> getClientes() {
		List<String> clientes = new ArrayList<>();
		clientes.add(new Cliente("Jhon", "Doe").getNombreCompleto());
		return clientes;
	}

}
