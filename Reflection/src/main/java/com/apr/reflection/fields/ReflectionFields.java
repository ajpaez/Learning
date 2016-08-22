package com.apr.reflection.fields;

import java.lang.reflect.Field;

/**
 * Fields and reflection
 * 
 */
public class ReflectionFields {

	public static void main(String[] args)
			throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		String stringer = "this is a String called stringer";

		@SuppressWarnings("unused")
		Class<? extends String> stringGetClass = stringer.getClass();

		Class<String> stringclass = String.class;

		Field[] fields = stringclass.getDeclaredFields();

		for (Field field : fields) {
			System.out.println("*************************");
			System.out.println("Name: " + field.getName());
			System.out.println("Type: " + field.getType());

			// values
			if (field.isAccessible()) {
				System.out.println("Get: " + field.get(stringer));
				// depending on the type we can access the fields using these
				// methods
				System.out.println("Get boolean: " + field.getBoolean(stringer));
				System.out.println("Get short: " + field.getShort(stringer));
				// ...
			}
			System.out.println("Modifiers:" + field.getModifiers());
			System.out.println("isAccesible: " + field.isAccessible());

		}

		try {
			stringclass.getField("hash");// exception
		} catch (Exception e) {
			System.err.println("ERROR: no se puede recuperar el campo con getField por ser privado ");
		}

		System.out.println("-----Recuperando el campo hash con getDeclaredField-----");
		String nuevoString = new String("Hola Mundo");
		Field fieldHashCode = nuevoString.getClass().getDeclaredField("hash");// all
																				// fields
		// can be accessed this way

		try {
			fieldHashCode.get(nuevoString.getClass());// exception
		} catch (IllegalAccessException e) {
			System.err.println("ERROR: no se puede recuperar el campo hash con su field por ser privado");
		}

		System.out.println("change the visibility");
		fieldHashCode.setAccessible(true);

		// and we can access it
		nuevoString.hashCode();
		Object value = fieldHashCode.get(nuevoString);
		int valueInt = fieldHashCode.getInt(nuevoString);
		System.out.println(value);
		System.out.println(valueInt);

	}
}
