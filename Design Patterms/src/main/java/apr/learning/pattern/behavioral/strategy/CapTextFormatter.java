package apr.learning.pattern.behavioral.strategy;

/**
 * Implementacion concreta de un text formatter concreto y clase usada para
 * cambiar el texto a mayusuculas
 * @author Antonio
 *
 */
public class CapTextFormatter implements TextFormatter{

	@Override
	public void format(String text) {
		System.out.println("[CapTextFormatter]: "+text.toUpperCase());
	}

}
