package com.apr.reflection.generics;

import java.util.List;

/**
 * Class to show how to use reflection and generics
 * 
 */
public class GenericsClass {

	List<String> internalList;

	public List<String> getInternalList() {
		return internalList;
	}

	public void setInternalList(List<String> internalList) {
		this.internalList = internalList;
	}

}
