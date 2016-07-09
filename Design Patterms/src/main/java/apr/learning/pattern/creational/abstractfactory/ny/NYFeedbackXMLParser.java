package apr.learning.pattern.creational.abstractfactory.ny;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class NYFeedbackXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("NY Parsing feedback XML...");
		return "NY Feedback XML Message";
	}

}

