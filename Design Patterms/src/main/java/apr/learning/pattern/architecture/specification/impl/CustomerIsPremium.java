package apr.learning.pattern.architecture.specification.impl;

import apr.learning.pattern.architecture.specification.CustomerSpecification;
import apr.learning.pattern.architecture.specification.dao.DaoCustomerMock;
import apr.learning.pattern.architecture.specification.model.Customer;

// Especificacion simple, tiene la logica que comprueba si un Customer es premiun de
//acuerdo a numero de pedidos

public class CustomerIsPremium implements CustomerSpecification {

    private DaoCustomerMock daoCustomer;

    public CustomerIsPremium(DaoCustomerMock daoCustomer) {
	this.daoCustomer = daoCustomer;
    }

    public boolean isSatisfiedBy(Customer customer) {
	return this.daoCustomer.countOrder(customer) > 3;
    }
}
