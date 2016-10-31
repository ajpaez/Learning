package apr.learning.pattern.architecture.specification.dao;

import apr.learning.pattern.architecture.specification.model.Customer;

public class DaoCustomerMock {

    public int countOrder(Customer c) {
	return 5;
    }

    public int countOverdueInvoices(Customer c) {
	return 0;
    }
}
