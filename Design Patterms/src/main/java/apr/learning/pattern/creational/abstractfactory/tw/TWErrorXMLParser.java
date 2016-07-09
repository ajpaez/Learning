package apr.learning.pattern.creational.abstractfactory.tw;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class TWErrorXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("TW Parsing error XML...");
		return "TW Error XML Message";
	}

}
