package apr.learning.pattern.structural.composite;

import java.util.List;

/***
 * 
 * @author Antonio
 * Representa la clase component que define todos los metodos usados por el composite y la clase leaf.  Hay metodos que deben ser comunes a ambas clases
 * extendidas, por lo tanto estos metodos se declaran como abstractos para asegurar que se implementan en las clases hijas. 
 * 
 */

public abstract class HtmlTag {
	
	public abstract String getTagName();
	public abstract void setStartTag(String tag);
	public abstract void setEndTag(String tag);
	
	public void setTagBody(String tagBody){
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}
	public void addChildTag(HtmlTag htmlTag){
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}
	public void removeChildTag(HtmlTag htmlTag){
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}
	public List<HtmlTag>getChildren(){
		throw new UnsupportedOperationException("Current operation is not support for this object");
	}
	public abstract void generateHtml();

}
