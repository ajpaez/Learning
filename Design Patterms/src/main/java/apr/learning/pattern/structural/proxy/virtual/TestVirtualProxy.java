package apr.learning.pattern.structural.proxy.virtual;

import java.util.List;

public class TestVirtualProxy {

	public static void main(String[] args) {
		ContactList contactList = new ContactListProxyImpl();
		//en primer lugar se crea el objeto Company con un objeto proxy ContactListProxyImpl,
		//en este momento el objeto empresa contiene una referencia proxy y no la verdadera hacia el objeto con
		//lista de empleados, por lo que no hay ninguna lista de empleados en memoria.
		Company company = new Company("ABC Company", "India", "+91-011-28458965", contactList);
		
		System.out.println("Company Name: "+company.getCompanyName());
		System.out.println("Company Address: "+company.getCompanyAddress());
		System.out.println("Company Contact No.: "+company.getCompanyContactNo());
		
		System.out.println("Requesting for contact list");
		
		// despues de algunas llamadas sobre el objeto company, preguntamos por la lista de empleados		
		contactList = company.getContactList();
		// en este momento el objeto proxy crea una objeto lista de empleados real y es el que devuelve
		List<Employee>empList = contactList.getEmployeeList();
		for(Employee emp : empList){
			System.out.println(emp);
		}
	}
	
}
