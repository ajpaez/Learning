package com.apr.reflection.enums;

import java.lang.reflect.Field;

import com.apr.reflection.Utils.Utils;

enum ExampleEnum {
	ONE(1), TWO(2), THREE(3), FOUR(4);

	Integer integer;

	ExampleEnum(Integer i) {
		this.integer = i;
	}

	Integer getMyValue(ExampleEnum e) {
		Integer result = 0;
		switch (integer) {
		case 1:
			result = 1;
			break;
		case 2:
			result = 2;
			break;

		default:
			break;
		}
		return result;
	}
};

/**
 * Enums and reflection
 * 
 */
public class ReflectionEnums {

	public static void main(String[] args) throws ClassNotFoundException {
		// we create an instance of the enum
		ExampleEnum enumValue = ExampleEnum.FOUR;

		// checks if the class is an enum
		System.out.println("isEnum? : " + enumValue.getClass().isEnum());

		// retrieves from the class all enum constants
		ExampleEnum[] enumConstants = enumValue.getClass().getEnumConstants();
		for (ExampleEnum exampleEnum : enumConstants) {
			System.out.println("enum constant " + exampleEnum);
		}

		Class<?> c = Class.forName("com.apr.reflection.enums.ExampleEnum");
		// Field[] flds = c.getClass().getDeclaredFields();
		Field[] flds = enumValue.getClass().getDeclaredFields();
		for (Field f : flds) {
			// check for each field if it is an enum constant or not
			System.out.println(f.getName() + " " + f.isEnumConstant());

			// NOTA: The string ENUM$VALUES false refers to the internal enum
			// values field.

		}

		// get all declared methods, also non public
		Utils.printAllMethod(enumValue.getClass());

	}
}
