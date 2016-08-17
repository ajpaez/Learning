package apr.annottations.java8anottations;

import java.util.ArrayList;
import java.util.List;

/**
 * Desde Java 8 También es posible utilizar las anotaciones de tipos. Es decir
 * cualquier lugar se puede utilizar un tipo, incluyendo el operador new,
 * castings, implents y clausulas throw. Las anotaciones de tipo permiten un
 * mejor análisis de código Java y pueden asegurar una comprobacion de tipo aún
 * más fuerte
 *
 */
public class Java8Annotated {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// type def
		@TypeAnnotated
		String cannotBeEmpty = null;

		// type
		List<@TypeAnnotated String> myList = new ArrayList<String>();

		// values
		String myString = new @TypeAnnotated String("this is annotated in java 8");

	}

	// in method params
	public void methodAnnotated(@TypeAnnotated int parameter) {
		System.out.println("do nothing");
	}
}
