package com.apr.javaee.cdi.interceptor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

@Log
@Stateful
public class BookShow implements Serializable {

	private static final long serialVersionUID = 187900457626086748L;

	public List<String> getMoviesList() {
		List<String> moviesAvailable = new ArrayList<String>();
		moviesAvailable.add("12 Angry Men");
		moviesAvailable.add("Kings speech");
		return moviesAvailable;
	}

	public Integer getDiscountedPrice(int ticketPrice) {
		return ticketPrice - 50;
	}
	// assume more methods are present

}
