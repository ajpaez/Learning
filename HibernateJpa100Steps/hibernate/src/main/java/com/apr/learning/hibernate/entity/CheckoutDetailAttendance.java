package com.apr.learning.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "CHECKOUTDETAILS_ATTENDANCE")
public class CheckoutDetailAttendance extends CheckoutDetail implements Serializable {

    @Column(name = "idAttendance", nullable = false)
    private Long idAttendance;


    public Long getId() {
        return id;
    }

    public Long getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Long idAttendance) {
        this.idAttendance = idAttendance;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckoutDetailAttendance that = (CheckoutDetailAttendance) o;
        return amount == that.amount &&
                Objects.equals(idAttendance, that.idAttendance) &&
                Objects.equals(checkout, that.checkout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAttendance, amount, checkout);
    }
}

