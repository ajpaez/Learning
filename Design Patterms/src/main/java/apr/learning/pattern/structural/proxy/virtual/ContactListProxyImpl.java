package apr.learning.pattern.structural.proxy.virtual;

import java.util.List;

/**
 * 
 * @author Antonio
 * Esta es la clase que se usará de proxy, tambien implementa ContactList y contine una referencia al objeto ContactList real. Sobre la implementacion de la interfaz en esta
 * clase, primero se comprueba si la referencia a contacList es nula y entonces se creará el objeto real y luego se invocará el metodo getEmployeeList para 
 * obtener la lista de empleados
 */
public class ContactListProxyImpl implements ContactList{

	private ContactList contactList;
	
	@Override
	public List<Employee> getEmployeeList() {
		if(contactList == null){
			System.out.println("Creating contact list and fetching list of employees...");
			contactList = new ContactListImpl();
		}
		return contactList.getEmployeeList();
	}
	

}
