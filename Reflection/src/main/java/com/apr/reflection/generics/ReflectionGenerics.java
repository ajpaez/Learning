package com.apr.reflection.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Generics and reflection. Con genéricos podemos: -Comprobar en tiempo de
 * ejecución si un elemento específico está parametrizado o no. -Recuperar los
 * tipos de los parámetros por reflexión
 */
public class ReflectionGenerics {
	public static void main(String[] args) throws NoSuchMethodException {
		extractGenericsArguments();
	}

	private static void extractGenericsArguments() throws NoSuchMethodException {
		// we retrieve a method
		Method getInternalListMethod = GenericsClass.class.getMethod("getInternalList");

		// we get the return type
		Type getInternalListMethodGenericReturnType = getInternalListMethod.getGenericReturnType();

		// we can check if the return type is parameterized (using
		// ParameterizedType)
		if (getInternalListMethodGenericReturnType instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType) getInternalListMethodGenericReturnType;
			// we get the type of the arguments for the parameterized type
			Type[] typeArguments = parameterizedType.getActualTypeArguments();
			for (Type typeArgument : typeArguments) {
				// we can work with that now
				Class<?> typeClass = (Class<?>) typeArgument;
				System.out.println("typeArgument = " + typeArgument);
				System.out.println("typeClass = " + typeClass);
			}
		}
	}

}
