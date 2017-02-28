package com.apr.javaee.cdi.interceptor;

import java.io.Serializable;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Log
@Priority(100)
public class LoggingInterceptor implements Serializable {

	private static final long serialVersionUID = 5908126011302054612L;

	@AroundInvoke
	public Object logMethodEntry(InvocationContext ctx) throws Exception {
		System.out.println("Entering method: " + ctx.getMethod().getName());
		return ctx.proceed();
	}
}