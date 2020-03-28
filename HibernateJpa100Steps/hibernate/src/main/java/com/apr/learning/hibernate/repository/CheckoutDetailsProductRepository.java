package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Checkout;
import com.apr.learning.hibernate.entity.CheckoutDetailProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

public interface CheckoutDetailsProductRepository extends JpaRepository<CheckoutDetailProduct, Long>, JpaSpecificationExecutor<CheckoutDetailProduct> {

    Collection<CheckoutDetailProduct> findAllByCheckout(Checkout checkout);

    CheckoutDetailProduct findByCheckout(Checkout checkout);

}
