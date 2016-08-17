package apr.annottations.java8anottations.inheritance;

import apr.annottations.customannotation.AnnotatedClass;

public class InheritanceExample {

	public static void main(String[] args) {
		System.out.println("is true: " + AnnotatedClass.class.isAnnotationPresent(InheritedAnnotation.class));

		System.out.println("is true: " + AnnotatedSubClass.class.isAnnotationPresent(InheritedAnnotation.class));

		System.out.println("is true: " + AnnotatedInterface.class.isAnnotationPresent(InheritedAnnotation.class));

		System.out
				.println("is true: " + AnnotatedImplementedClass.class.isAnnotationPresent(InheritedAnnotation.class));
	}
}
