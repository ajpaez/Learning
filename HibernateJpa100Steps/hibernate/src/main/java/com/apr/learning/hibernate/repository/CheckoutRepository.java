package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CheckoutRepository extends JpaRepository<Checkout, Long>, JpaSpecificationExecutor<Checkout> {

}
