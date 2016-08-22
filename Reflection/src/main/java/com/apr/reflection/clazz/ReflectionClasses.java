package com.apr.reflection.clazz;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

import com.apr.reflection.Utils.Utils;

/**
 * Classes and reflection: private methods, static methods and elements,
 * getters, setters, constructors
 * http://docs.oracle.com/javase/7/docs/api/java/lang/Class.html
 * 
 */
public class ReflectionClasses {
	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		String stringer = "this is a String called stringer";

		// get class from a single instance
		Class<? extends String> stringGetClass = stringer.getClass();
		System.out.println(
				"Nombre de la clase a partir de la class de una instancia: " + stringGetClass.getCanonicalName());

		// get class from a class name without instantiation
		Class<String> stringclass = String.class;
		System.out.println("Nombre de la clase a partir del .class: " + stringGetClass.getCanonicalName());

		// get class using the method java.lang.Class.forName(String)
		Class<?> stringGetClass2 = Class.forName("java.lang.String");
		System.out.println("Nombre de la clase a partir de la clase: " + stringGetClass.getCanonicalName());

		System.out.println(stringGetClass.getCanonicalName().equals(stringclass.getCanonicalName()));
		System.out.println(stringGetClass.getCanonicalName().equals(stringGetClass2.getCanonicalName()));

		// ======================================================

		// A partir de un objeto de clase podemos recuperar todo tipo de
		// información, como métodos declarados, constructores, campos visibles,
		// anotaciones, tipos ...

		// get all accesible methods
		Method[] methods = stringclass.getMethods();

		// get all declared methods, also non public
		Utils.printAllMethod(stringGetClass);

		// gets a specific method
		Method equalsMethod = stringGetClass.getMethod("equalsIgnoreCase", String.class);

		// for more info
		// http://docs.oracle.com/javase/7/docs/api/java/lang/reflect/Modifier.html
		int modifiers = stringGetClass.getModifiers();

		// the same for abstract, volatile, etc
		System.out.println("is public? :  " + Modifier.isPublic(modifiers));

		// ======================================================

		// get all fields
		Field[] fields = stringGetClass.getFields();

		System.out.println("--------- Campos de la clase ---------");
		for (Field campo : fields) {
			System.out.print(campo.getName() + "; ");
		}

		// get a declared field, the class String has no public fields
		stringGetClass.getDeclaredField("hash");

		// ======================================================

		// get all visible constructors
		Constructor<?>[] constructors = stringGetClass.getConstructors();

		// all constructors
		Constructor<?>[] declaredConstructors = stringclass.getDeclaredConstructors();

		for (Constructor<?> contructor : declaredConstructors) {
			System.out.print(contructor.getName() + "; ");
		}

		System.out.println("number of visible constructors: " + constructors.length);

		System.out.println("number of total constructors: " + declaredConstructors.length);

		System.out.println("--------- Constructores de la clase ---------");
		for (Constructor<?> constructor : constructors) {
			int numberParams = constructor.getParameterCount();
			System.out.println("constructor: " + constructor.getName());
			System.out.println("number of arguments " + numberParams);
			// public, private, etc.
			int modifiersConstructor = constructor.getModifiers();
			System.out.println("modifiers " + modifiersConstructor);
			// array of parameters, more info in the methods section

			Parameter[] parameters = constructor.getParameters();
			// annotations array, more info in the annotations section

			Annotation[] annotations = constructor.getAnnotations();

			if (numberParams == 1 && parameters[0].getClass().equals(String.class)) {
				// can be used to create new instances

				String stringCreadaPorReflexion = (String) constructor.newInstance("Hola");
				System.out.println("String creada por reflexion: " + stringCreadaPorReflexion);
			}
		}

		// ======================================================

		// get the component type
		Class<?> componentType = stringGetClass.getComponentType();

		// get the type name
		String typename = stringGetClass.getTypeName();
		System.out.println("type name " + typename);

		// returns true if the object is instance of the class, false otherwise
		System.out.println("Se instancio el string por reflexion ? : " + stringGetClass.isInstance("Hola"));

		// checks if the object is of a primitive type, in this case, not
		System.out.println("Es primitica la clase ? " + stringGetClass.isPrimitive());

		Class<?> enclosingClass = stringGetClass.getEnclosingClass();
		System.out.println("enclosing class " + enclosingClass);

		// it is possible to create instance at runtime

		String newInstanceStringClass = stringclass.newInstance();

		String otherInstance = (String) Class.forName("java.lang.String").newInstance();
	}
}
