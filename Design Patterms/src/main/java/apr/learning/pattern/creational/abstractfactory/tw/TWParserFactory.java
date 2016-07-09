package apr.learning.pattern.creational.abstractfactory.tw;

import apr.learning.pattern.creational.abstractfactory.AbstractParserFactory;
import apr.learning.pattern.creational.abstractfactory.XMLParser;

/**
 * Implementacion de factoria concreta
 * @author Antonio
 *
 */
public class TWParserFactory implements AbstractParserFactory {

	@Override
	public XMLParser getParserInstance(char parserType) {
		
		switch(parserType){
			case 'E': return new TWErrorXMLParser();
			case 'F': return new TWFeedbackXMLParser();
			case 'O': return new TWOrderXMLParser();
			case 'R': return new TWResponseXMLParser();
		}
		
		return null;
	}

}
