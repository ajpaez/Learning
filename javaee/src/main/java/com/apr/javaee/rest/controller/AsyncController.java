package com.apr.javaee.rest.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.apr.javaee.cdi.inject.concurrent.MyRunnable;

//rest
@Stateless
@Path("async")
@Produces({ MediaType.APPLICATION_JSON })
public class AsyncController {

	private final ExecutorService executorService = Executors.newCachedThreadPool();
	@Resource
	ManagedExecutorService managedExecutorService;
	@Inject
	Instance<MyRunnable> myTaskInstance;

	@GET
	@Path("longtask")
	public void longtask(@Suspended final AsyncResponse asyncResponse) {

		// Set time out for the request
		asyncResponse.setTimeout(10, TimeUnit.SECONDS);

		Runnable longRunningDeptQuery = new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(5000); // long task
				} catch (InterruptedException e) {
					e.printStackTrace();
					asyncResponse.cancel();
				}
				asyncResponse.resume(Response.ok().build());
			}
		};
		executorService.execute(longRunningDeptQuery);

	}

	@GET
	@Path("concurrent")
	public Response checkConcurrentCdi() {

		for (int i = 0; i < 10; i++) {
			MyRunnable myTask = myTaskInstance.get();
			myTask.setName(String.valueOf(i));
			managedExecutorService.submit(myTask);
		}

		return Response.status(Response.Status.OK).build();

	}

}
