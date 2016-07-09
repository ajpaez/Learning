package apr.learning.pattern.creational.abstractfactory.tw;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class TWOrderXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("TW Parsing order XML...");
		return "TW Order XML Message";
	}

}

