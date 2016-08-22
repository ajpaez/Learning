package com.apr.reflection.interfaces;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Interfaces and reflection
 * 
 */
public class ReflectionInterfaces {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		Class<?> mapInterface = Map.class;

		// can be accessed like a class
		System.out.println("interface name: " + mapInterface.getName());

		try {
			// cannot be instantiated: java.lang.InstantiationException
			Map.class.newInstance();
		} catch (Exception e) {
			System.err.println("No puedes instanciar una interfaz");
		}

		// get all declared methods, also non public
		Method[] declaredMethods = mapInterface.getDeclaredMethods();
		System.out.println("--------- Metodos de la interfaz ---------");
		for (Method metodo : declaredMethods) {
			System.out.print(metodo.getName() + "; ");
		}
	}

}
