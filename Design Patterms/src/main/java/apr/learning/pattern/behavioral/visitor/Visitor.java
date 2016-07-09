package apr.learning.pattern.behavioral.visitor;

/**
 * Esta interfaz contiene metodos visit, con un argumento de la clases que
 * implementan la interfaz Element
 * @author Antonio
 *
 */
public interface Visitor {
	public void visit(HtmlElement element);
	public void visit(HtmlParentElement parentElement);
}
