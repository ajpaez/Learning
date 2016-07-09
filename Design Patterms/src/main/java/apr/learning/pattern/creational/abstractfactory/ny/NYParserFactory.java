package apr.learning.pattern.creational.abstractfactory.ny;

import apr.learning.pattern.creational.abstractfactory.AbstractParserFactory;
import apr.learning.pattern.creational.abstractfactory.XMLParser;

/**
 * Implementacion de factoria concreta
 * @author Antonio
 *
 */
public class NYParserFactory implements AbstractParserFactory {

	@Override
	public XMLParser getParserInstance(char parserType) {
		
		switch(parserType){
			case 'E': return new NYErrorXMLParser();
			case 'F': return new NYFeedbackXMLParser();
			case 'O': return new NYOrderXMLParser();
			case 'R': return new NYResponseXMLParser();
		}
		
		return null;
	}

}
