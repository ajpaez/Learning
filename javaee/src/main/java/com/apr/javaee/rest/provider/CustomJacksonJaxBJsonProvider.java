package com.apr.javaee.rest.provider;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class CustomJacksonJaxBJsonProvider extends JacksonJaxbJsonProvider {

	private static ObjectMapper commonMapper = null;

	public CustomJacksonJaxBJsonProvider() {
		super();
		if (commonMapper == null) {
			ObjectMapper mapper = new ObjectMapper();

			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

			mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
			mapper.configure(SerializationFeature.INDENT_OUTPUT, false);
			mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);

			mapper.registerModule(new JaxbAnnotationModule());

			commonMapper = mapper;
		}
		super.setMapper(commonMapper);
	}
}
