package apr.learning.pattern.behavioral.template;

import java.util.Date;

/**
 * Esta clase abstracta provee los pasos necesarios para conectarse, comunicarse y 
 * posteriormente cerrar las conexiones. Todos estos pasos requieren un orden con el fin de 
 * hacer el trabajo correctamente. La clase proporciona implementaciones por defecto con pasos
 * comunes y deja algunos pasos especificos como abstractos que obligan al clientes a proveer
 * una implementacion para ellos.
 * 
 * 
 * @author Antonio
 *
 */
public abstract class ConnectionTemplate {
	
	private boolean isLoggingEnable = true;
	
	public ConnectionTemplate(){
		isLoggingEnable = disableLogging();
	}
	
	public final void run(){
		
		setDBDriver();
		logging("Drivers set ["+new Date()+"]");
		setCredentials();
		logging("Credentails set ["+new Date()+"]");
		connect();
		logging("Conencted");
		prepareStatement();
		logging("Statement prepared ["+new Date()+"]");
		setData();
		logging("Data set ["+new Date()+"]");
		insert();
		logging("Inserted ["+new Date()+"]");
		close();
		logging("Conenctions closed ["+new Date()+"]");
		destroy();
		logging("Object destoryed ["+new Date()+"]");
		
	}
	
	public abstract void setDBDriver();

	public abstract void setCredentials(); 

	public void connect(){
		System.out.println("Setting connection...");
	}
	
	public void prepareStatement(){
		System.out.println("Preparing insert statement...");
	}
	
	public abstract void setData();
	
	public void insert(){
		System.out.println("Inserting data...");
	}
	
	public void close(){
		System.out.println("Closing connections...");
	}

	public void destroy(){
		System.out.println("Destroying connection objects...");
	}
	
	public boolean disableLogging(){
		return true;
	}
	
	private void logging(String msg){
		if(isLoggingEnable){
			System.out.println("Logging....: "+msg);
		}
	}
}
