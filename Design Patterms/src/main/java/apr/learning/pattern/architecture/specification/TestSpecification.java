package apr.learning.pattern.architecture.specification;

import apr.learning.pattern.architecture.specification.dao.DaoCustomerMock;
import apr.learning.pattern.architecture.specification.impl.AndSpecification;
import apr.learning.pattern.architecture.specification.impl.CustomerHasOverdueInvoices;
import apr.learning.pattern.architecture.specification.impl.CustomerIsPremium;
import apr.learning.pattern.architecture.specification.model.Customer;

public class TestSpecification {

    public static void main(String[] args) {
	DaoCustomerMock dao = new DaoCustomerMock();
	AndSpecification spec = new AndSpecification(new CustomerIsPremium(dao), new CustomerHasOverdueInvoices(dao));

	System.out.println(spec.isSatisfiedBy(new Customer()));

    }

}
