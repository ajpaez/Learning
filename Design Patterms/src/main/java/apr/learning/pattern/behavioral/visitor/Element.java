package apr.learning.pattern.behavioral.visitor;

/**
 * Interfaz que contiene el mentodo accept con el argumento de tipo Visitor
 * Esta interfaz será implementada por todas las clases que necesiten permitir
 * a los visitor que las visiten.
 * En nuestro caso HtmlTag implementara dicha interfaz, como esta clase abstracta
 * es padre de todas las clases concretas de HTML, las clases hijas heredan el metodo.
 * @author Antonio
 *
 */
public interface Element {
	
	public void accept(Visitor visitor);
}
