package com.apr.javaee.rest.excepctionmapper;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BeanValidatorExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException e) {
		System.out.println("BeanValConstrainViolationExceptionMapper in action");

		ConstraintViolation cv = (ConstraintViolation) e.getConstraintViolations().toArray()[0];

		return Response.status(Response.Status.PRECONDITION_FAILED).build();
	}

}
