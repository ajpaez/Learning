package com.apr.reflection.constructors;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

/**
 * Constructors and reflection
 * 
 */
public class ReflectionConstructors {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Integer myInteger = 112358;

		Class<? extends Integer> stringGetClass = myInteger.getClass();
		// get all visible constructors
		Constructor<?>[] constructors = stringGetClass.getConstructors();

		// get all constructors
		constructors = stringGetClass.getDeclaredConstructors();

		for (Constructor<?> constructor : constructors) {
			System.out.println("*************************");
			int numberParams = constructor.getParameterCount();
			System.out.println("constructor " + constructor.getName());
			System.out.println("number of arguments " + numberParams);
			// public, private, etc.
			int modifiersConstructor = constructor.getModifiers();
			System.out.println("modifiers " + modifiersConstructor);
			// array of parameters, more info in the methods section
			System.out.println("        --------PARAMETERS--------");
			Parameter[] parameters = constructor.getParameters();
			for (Parameter parameter : parameters) {
				System.out.println("Name: " + parameter.getName() + " Type: " + parameter.getType());
			}
			// annotations array, more info in the annotations section
			Annotation[] annotations = constructor.getAnnotations();
		}

		// Estos constructores pueden ser usados para crear nuevas instancias.
		try {
			Integer myNewInteger = (Integer) constructors[0].newInstance(12357);
			System.out.println("Integer creado por reflexion a partir de un integer: " + myNewInteger);
			myNewInteger = (Integer) constructors[1].newInstance("1235711");
			System.out.println("Integer creado por reflexion a partir de un string : " + myNewInteger);

		} catch (InstantiationException | InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
