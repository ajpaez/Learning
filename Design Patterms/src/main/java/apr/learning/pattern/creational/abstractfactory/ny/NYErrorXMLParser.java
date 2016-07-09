package apr.learning.pattern.creational.abstractfactory.ny;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class NYErrorXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("NY Parsing error XML...");
		return "NY Error XML Message";
	}

}
