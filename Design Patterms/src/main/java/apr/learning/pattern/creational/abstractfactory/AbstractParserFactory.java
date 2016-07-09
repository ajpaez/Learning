package apr.learning.pattern.creational.abstractfactory;

/**
 * Interfaz que implementaran todas las interfaces concretas
 * @author Antonio
 *
 */
public interface AbstractParserFactory {

	public XMLParser getParserInstance(char parserType);
}
