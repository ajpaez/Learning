package apr.learning.pattern.architecture.dao;

import apr.learning.pattern.architecture.dao.bo.Customer;

/**
 * Interfaz que implementaran los daos para la gestion de clientes
 * @author Antonio
 *
 */
public interface CustomerDAO {
	public int insertCustomer(Customer c);

	public boolean deleteCustomer(Customer c);

	public Customer findCustomer(Customer c);
}
