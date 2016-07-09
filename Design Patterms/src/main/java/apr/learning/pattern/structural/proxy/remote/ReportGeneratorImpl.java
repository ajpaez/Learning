package apr.learning.pattern.structural.proxy.remote;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


/**
 * 
 * @author Antonio
 * Esta clase es la implementacion remota que hace el trabajo real. Representa el objeto al que el cliente lanzará las peticiones remotas. La clase extiende de 
 * UnicastRemoteObject con el fin de trabajar como un objeto de servicio remoto, tu objeto necesita necesita alguna funcionalidad relaccionado con ser remoto.
 * La forma mas sencilla para esto es extender UnicastRemoteObject del paquete java.rem.server y dejar que la calse trabaje por ti.
 * 
 */
public class ReportGeneratorImpl extends UnicastRemoteObject implements ReportGenerator{

	private static final long serialVersionUID = 3107413009881629428L;

	protected ReportGeneratorImpl() throws RemoteException {
	}

	@Override
	public String generateDailyReport() throws RemoteException {
		StringBuilder sb = new StringBuilder();
		sb.append("********************Location X Daily Report********************");
		sb.append("\n Location ID: 012");
		sb.append("\n Today's Date: "+new Date());
		sb.append("\n Total Pizza Sell: 112");
		sb.append("\n Total Sale: $2534");
		sb.append("\n Net Profit: $1985");
		sb.append("\n ***************************************************************");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		try {
			ReportGenerator reportGenerator = new ReportGeneratorImpl();
			Naming.rebind("PizzaCoRemoteGenerator", reportGenerator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
