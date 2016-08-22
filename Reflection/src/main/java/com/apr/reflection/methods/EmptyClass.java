package com.apr.reflection.methods;

public class EmptyClass {

	// the method visibility should be changed in order to access it at runtime,
	// may be prevented
	// under specific circumstances
	private boolean isEmpty() {
		return false;
	}

}
