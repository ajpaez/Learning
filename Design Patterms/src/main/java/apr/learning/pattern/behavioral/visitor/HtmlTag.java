package apr.learning.pattern.behavioral.visitor;

import java.util.List;


public abstract class HtmlTag implements Element{
	
	public abstract String getTagName();
	public abstract void setStartTag(String tag);
	public abstract String getStartTag();
	public abstract String getEndTag();
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
