package apr.learning.pattern.architecture.dao.impl;

import java.sql.Connection;

import apr.learning.pattern.architecture.dao.CustomerDAO;
import apr.learning.pattern.architecture.dao.bo.Customer;

/**
 * DAO que maneja la tabla de clientes para la conexion pasado por 
 * constructor
 * @author Antonio
 *
 */
public class CustomerDAOImpl implements  CustomerDAO {

	public CustomerDAOImpl(Connection c) {
	}

	@Override
	public int insertCustomer(Customer c) {
		//Codigo para insertar un customer
		return 0;
	}

	@Override
	public boolean deleteCustomer(Customer c) {
		//Codigo para eliminar un customer
		return false;
	}

	@Override
	public Customer findCustomer(Customer c) {
		//Codigo para buscar un customer
		return null;
	}

	

}
