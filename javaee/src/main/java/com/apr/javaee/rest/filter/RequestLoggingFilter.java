package com.apr.javaee.rest.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

/**
 * The ContainerRequestFilters implementations, by default, are postmatching
 * (unless you designate them as @PreMatching)
 *
 */

@Provider
@LoggingFilterBinding
@Priority(Priorities.USER)
public class RequestLoggingFilter implements ContainerRequestFilter {

	@Override
	public void filter(final ContainerRequestContext requestContext) throws IOException {
		UriInfo uriInfo = requestContext.getUriInfo();
		String uri = uriInfo.getRequestUri().toString();
		System.out.println("RequestLoggingFilter implements ContainerRequestFilter initialized in -> " + uri);

	}
}
