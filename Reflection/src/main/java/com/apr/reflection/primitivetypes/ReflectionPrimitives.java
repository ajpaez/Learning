package com.apr.reflection.primitivetypes;

/**
 * En Java, hay un par de tipos que se manejan de manera distinta dada su
 * naturaleza y comportamiento: cuando hablamos sobre reflexión, tipos
 * primitivos como int, float, double, etc. pueden ser accesibles y utilizarse
 * casi como cualquier otra clase.
 *
 */
public class ReflectionPrimitives {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {

		Class<Integer> intClass = int.class;

		System.out.println("is primitive? : " + intClass.isPrimitive());

		try {
			Integer intInstance = intClass.newInstance();
		} catch (InstantiationException e) {
			System.err.println("No es posible crea una instancia de tipo primitivo");
		}

	}
}
