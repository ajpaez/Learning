package com.apr.learning.hibernate.repository;

import com.apr.learning.hibernate.entity.Checkout;
import com.apr.learning.hibernate.entity.CheckoutDetailAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

public interface CheckoutDetailsAttendanceRepository extends JpaRepository<CheckoutDetailAttendance, Long>, JpaSpecificationExecutor<CheckoutDetailAttendance> {

    public Collection<CheckoutDetailAttendance> findAllByCheckout(Checkout checkout);

}
