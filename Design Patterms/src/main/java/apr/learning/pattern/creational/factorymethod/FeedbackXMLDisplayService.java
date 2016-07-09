package apr.learning.pattern.creational.factorymethod;

public class FeedbackXMLDisplayService extends DisplayService{

	@Override
	public XMLParser getParser() {
		return new FeedbackXMLParser();
	}

}