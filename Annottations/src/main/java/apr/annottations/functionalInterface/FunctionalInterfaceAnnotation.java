package apr.annottations.functionalInterface;

/*
 * Una interfaz funcional es aquella interfaz que se implementa la funcionalidad de 
 * sus metodos mediante la creación de clases internas anónimas utilizando estas interfaces
 * u operaciones lambda. 
 * Estas interfaces también se llaman las interfaces Single Abstract Method (SAM Interfaces).
 * Otros ejemplos de este tipo de interfaz son java.lang.Runnable, java.awt.event.ActionListener,
 * java.util.Comparator, java.util.concurrent.Callable.
 * 
 * Esta anotacion puede ser aplicada a clases, interfaces, enums y anotaciones y es conservada 
 * por la JVM y esta disponible en tiempo de ejecucion
 */
public class FunctionalInterfaceAnnotation {

	public static void main(String[] args) {

		// implementing its methods
		@SuppressWarnings("unused")
		MyCustomInterface myFuncInterface = new MyCustomInterface() {

			@Override
			public int doSomething(int param) {
				return param * 10;
			}
		};

		// using lambdas
		@SuppressWarnings("unused")
		MyCustomInterface myFuncInterfaceLambdas = (x) -> (x * 10);
	}

	@FunctionalInterface
	interface MyCustomInterface {
		/*
		 * more abstract methods will cause the interface not to be a valid
		 * functional interface and the compiler will thrown an error:Invalid
		 * '@FunctionalInterface' annotation;
		 * FunctionalInterfaceAnnotation.MyCustomInterface is not a functional
		 * interface
		 */

		// boolean isFunctionalInterface();

		int doSomething(int param);
	}

}
