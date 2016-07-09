package apr.learning.pattern.structural.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * 
 * @author Antonio
 * Esta es la interfaz remota que define los metodos que un cliente puede llamar de forma remota. En lo que el cliente utilizará como el 
 * tipo de clase para su servicio. Tanto el Stub com oel actual servicio deberan implementarla. El metodo en la interfaz devuelve un String.
 * Tu puedes devolver cualquier objeto, este será enviado a traves a traves de la red desde el servidor hasta el cliente, así que debera ser
 * serializable. Tenga en cuenta que todos los metodos de esta interfaz deben devolver RemoteException.
 */
public interface ReportGenerator extends Remote{
	
	public String generateDailyReport() throws RemoteException;

}
