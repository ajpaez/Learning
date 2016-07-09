package apr.learning.pattern.creational.abstractfactory;

import apr.learning.pattern.creational.abstractfactory.ny.NYParserFactory;
import apr.learning.pattern.creational.abstractfactory.tw.TWParserFactory;


/**
 * Factory producer que evita la dependencia entre el codigo de clientes
 * y factorias, es responsable de proporcionar un objeto de tipo factory
 * segun la necesidad del cliente
 * @author Antonio
 *
 */
public final class ParserFactoryProducer {

	private ParserFactoryProducer(){
		throw new AssertionError();
	}

	public static AbstractParserFactory getFactory(char factoryType){
		
		switch(factoryType)
		{
			case 'N': return new NYParserFactory();
			case 'T': return new TWParserFactory();
		}

		return null;
	}

}
