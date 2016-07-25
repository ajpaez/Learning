package apr.learning.pattern.architecture.dao;

import apr.learning.pattern.architecture.dao.bo.Customer;
import apr.learning.pattern.architecture.dao.factorys.DAOFactory;

public class TestDao {

	public static void main(String[] args) {
		// create the required DAO Factory
		DAOFactory OracleDbFactory = DAOFactory.getDAOFactory(DAOFactory.ORACLE);

		// Create a DAO
		CustomerDAO customerDAOOracle = OracleDbFactory.getCustomerDAO();

		Customer c = new Customer();
		// create a new customer
		int newCustNo = customerDAOOracle.insertCustomer(c);
		c.setId(newCustNo);

		// Find a customer object. Get the Transfer Object.
		Customer cust = customerDAOOracle.findCustomer(c);

		// delete a customer object
		customerDAOOracle.deleteCustomer(cust);

		DAOFactory sybaseDbFactory = DAOFactory.getDAOFactory(DAOFactory.SYBASE);
		// Create a DAO
		CustomerDAO customerDAOSybase = sybaseDbFactory.getCustomerDAO();

		customerDAOSybase.findCustomer(c);
		customerDAOSybase.deleteCustomer(cust);
	}

}
