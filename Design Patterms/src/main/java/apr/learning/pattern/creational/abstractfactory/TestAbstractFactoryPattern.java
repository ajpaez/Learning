package apr.learning.pattern.creational.abstractfactory;

public class TestAbstractFactoryPattern {

	public static void main(String[] args) {
		
		AbstractParserFactory parserFactory = ParserFactoryProducer.getFactory('N');
		XMLParser parser = parserFactory.getParserInstance('O');
		String msg="";
		msg = parser.parse();
		System.out.println(msg);
		
		System.out.println("************************************");
		
		parserFactory = ParserFactoryProducer.getFactory('T');
		parser = parserFactory.getParserInstance('F');
		msg = parser.parse();
		System.out.println(msg);
	}

}
