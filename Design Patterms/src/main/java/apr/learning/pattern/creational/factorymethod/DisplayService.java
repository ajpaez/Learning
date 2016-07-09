package apr.learning.pattern.creational.factorymethod;


/**
 * Esta clase se usa para mostrar el mensaje obtenido al analizar 
 * el xml del usuario. El metodo getParser es el metodo factory, que es 
 * implementado por las subclases para crear las instancias del objeto 
 * Parser 
 * @author Antonio
 *
 */
public abstract class DisplayService {
	
	public void display(){
		XMLParser parser = getParser();
		String msg = parser.parse();
		System.out.println(msg);
	}
	
	protected abstract XMLParser getParser();

}
