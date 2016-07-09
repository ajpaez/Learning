package apr.learning.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Crea y administra los objetos flyweght, asegura que los objetos flyweght se comparten adecuadamente, cuando un cliente
 * solicita uno de sus objetos, si no existe niinguna la crea, sino suministra la que ya existe.
 * @author Antonio
 *
 */

public final class PlatformFactory {
	
	private static Map<Character, Platform>map = new HashMap<Character, Platform>();
	private PlatformFactory(){
		throw new AssertionError("Cannot instantiate the class");
	}
	
	public static synchronized Platform getPlatformInstance(char c){
		Platform platform = map.get(c);
		if(platform==null){
			switch(c){
				case 'C' : platform = new CPlatform(); 
						   break;
				case 'D' : platform = new CPPPlatform(); 
				   		   break;
				case 'J' : platform = new JavaPlatform(); 
				   		   break;
				case 'R' : platform = new RubyPlatform(); 
				   		   break;   		   
			}
			map.put(c, platform);
		}
		return platform;
	}

}
