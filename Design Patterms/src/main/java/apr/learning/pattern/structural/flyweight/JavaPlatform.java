package apr.learning.pattern.structural.flyweight;

/**
 * Implementa la interfaz flywegth y añade almacenamiento para el estado intrinseco, si lo hubiere. Cualquiera de las implementaciones
 * de la interfaz debe ser compartible. Cualquier estado que almacene debe de ser intrinseco, es decir, que debe ser independiente del 
 * contexto de este objeto.
 * @author Antonio
 *
 */

public class JavaPlatform implements Platform {

	public JavaPlatform(){
		System.out.println("JavaPlatform object created");
	}
	
	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing " + code.getCode());
	}

}
