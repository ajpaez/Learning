package apr.learning.pattern.creational.abstractfactory.ny;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class NYOrderXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("NY Parsing order XML...");
		return "NY Order XML Message";
	}

}

