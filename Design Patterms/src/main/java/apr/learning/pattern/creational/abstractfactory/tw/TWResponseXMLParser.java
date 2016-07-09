package apr.learning.pattern.creational.abstractfactory.tw;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class TWResponseXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("TW Parsing response XML...");
		return "TW Response XML Message";
	}

}
