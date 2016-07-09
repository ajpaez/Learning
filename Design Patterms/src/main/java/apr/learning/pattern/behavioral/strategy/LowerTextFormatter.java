package apr.learning.pattern.behavioral.strategy;

/**
 * Implementacion concreta de un text formatter concreto y clase usada para
 * cambiar el texto a minisculas
 * @author Antonio
 *
 */
public class LowerTextFormatter implements TextFormatter{

	@Override
	public void format(String text) {
		System.out.println("[LowerTextFormatter]: "+text.toLowerCase());
	}

}
