package apr.learning.pattern.creational.abstractfactory.ny;

import apr.learning.pattern.creational.abstractfactory.XMLParser;

public class NYResponseXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("NY Parsing response XML...");
		return "NY Response XML Message";
	}

}
