package apr.annottations.java8anottations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import apr.annottations.customannotation.AnnotatedClass;
import apr.annottations.customannotation.CustomAnnotationForClass;
import apr.annottations.customannotation.CustomAnnotationForMethod;

public class ReadAnnotations {

	public static void main(String[] args) throws Exception {

		Class<AnnotatedClass> object = AnnotatedClass.class;
		// Retrieve all annotations from the class
		Annotation[] annotations = object.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}

		// Checks if an annotation is present
		if (object.isAnnotationPresent(CustomAnnotationForClass.class)) {

			// Gets the desired annotation
			Annotation annotation = object.getAnnotation(CustomAnnotationForClass.class);

			System.out.println("La clase esta anotada con: " + annotation);

		}
		// the same for all methods of the class
		for (Method method : object.getDeclaredMethods()) {

			if (method.isAnnotationPresent(CustomAnnotationForMethod.class)) {

				Annotation annotation = method.getAnnotation(CustomAnnotationForMethod.class);

				System.out.println("La clase esta anotada en algun metodo con: " + annotation);

			}

		}
	}
}
