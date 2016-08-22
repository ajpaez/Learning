package com.apr.reflection.Utils;

import java.lang.reflect.Method;

public class Utils {

	public static void printAllMethod(Class<?> clazz) {

		// get all declared methods, also non public
		Method[] declaredMethods = clazz.getDeclaredMethods();
		System.out.println("--------- Metodos de la clase ---------");
		for (Method metodo : declaredMethods) {
			System.out.print(metodo.getName() + "; ");
		}

	}
}
