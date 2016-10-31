package apr.learning.pattern.architecture.specification.impl;

import apr.learning.pattern.architecture.specification.CustomerSpecification;
import apr.learning.pattern.architecture.specification.model.Customer;

public class AndSpecification implements CustomerSpecification {

    CustomerSpecification one;
    CustomerSpecification two;

    public AndSpecification(CustomerSpecification one, CustomerSpecification two) {
	this.one = one;
	this.two = two;
    }

    @Override
    public boolean isSatisfiedBy(Customer customer) {
	return this.one.isSatisfiedBy(customer) && this.two.isSatisfiedBy(customer);
    }
}
