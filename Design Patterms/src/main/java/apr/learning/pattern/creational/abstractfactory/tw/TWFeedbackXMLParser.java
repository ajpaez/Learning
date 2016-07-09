package apr.learning.pattern.creational.abstractfactory.tw;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class TWFeedbackXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("TW Parsing feedback XML...");
		return "TW Feedback XML Message";
	}

}

