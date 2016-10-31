package apr.learning.pattern.architecture.specification;

import apr.learning.pattern.architecture.specification.model.Customer;

public interface CustomerSpecification {

    public boolean isSatisfiedBy(Customer customer);

}
