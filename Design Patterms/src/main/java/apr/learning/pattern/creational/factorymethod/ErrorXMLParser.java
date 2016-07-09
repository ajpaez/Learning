package apr.learning.pattern.creational.factorymethod;

public class ErrorXMLParser implements XMLParser{

	@Override
	public String parse() {
		System.out.println("Parsing error XML...");
		return "Error XML Message";
	}

}
