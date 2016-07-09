package apr.learning.pattern.creational.prototype;

import java.util.HashMap;
import java.util.Map;

//clase que contiene la creacion de objetos/propiedades muy pesadas para su creacion
public class AccessControlProvider {
	
	private static Map<String, AccessControl>map = new HashMap<String, AccessControl>();
	
	static{
		
		System.out.println("Fetching data from external resources and creating access control objects...");
		map.put("USER", new AccessControl("USER","DO_WORK"));
		map.put("ADMIN", new AccessControl("ADMIN","ADD/REMOVE USERS"));
		map.put("MANAGER", new AccessControl("MANAGER","GENERATE/READ REPORTS"));
		map.put("VP", new AccessControl("VP","MODIFY REPORTS"));
	}
	
	/**
	 * Metodo usado para obtener la nueva copia del objeto AccesControl cuando se desea cambiar el acceso para un usuario distinto,
	 * a traves del metodo clone, lo que hace es devolver una nueva copia y no una referencia que apunta al mismo objeto
	 * @param controlLevel
	 * @return
	 */
	public static AccessControl getAccessControlObject(String controlLevel){
		AccessControl ac = null;
		ac = map.get(controlLevel);
		if(ac!=null){
			return ac.clone();
		}
		return null;
	}
}
