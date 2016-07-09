package apr.learning.pattern.behavioral.visitor;

/**
 * Clase que implementa Visitor y sera usada para cambiar
 *  el ancho de la etiqueta
 * 
 * @author Antonio
 *
 */
public class StyleVisitor implements Visitor {

	@Override
	public void visit(HtmlElement element) {
		element.setStartTag(element.getStartTag().replace(">", " style='width:46px;'>"));
		
	}

	@Override
	public void visit(HtmlParentElement parentElement) {
		parentElement.setStartTag(parentElement.getStartTag().replace(">", " style='width:58px;'>"));
	}

}
