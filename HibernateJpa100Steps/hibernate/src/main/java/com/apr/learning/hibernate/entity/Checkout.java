package com.apr.learning.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "CHECKOUTS")
public class Checkout implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idCustomer", nullable = false)
    private Long idCustomer;


    @OneToMany(
            mappedBy = "checkout",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<CheckoutDetailAttendance> checkoutDetailsAttendance;

    @OneToMany(
            mappedBy = "checkout",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<CheckoutDetailProduct> checkoutDetailsProduct;


    public Checkout() {
        this.checkoutDetailsAttendance = new HashSet<>();
        this.checkoutDetailsProduct = new HashSet<>();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Long idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void addAttendanceDetail(CheckoutDetailAttendance checkoutDetail) {
        checkoutDetailsAttendance.add(checkoutDetail);
        checkoutDetail.setCheckout(this);
    }

    public void removeAttendanceDetail(CheckoutDetailAttendance checkoutDetail) {
        checkoutDetailsAttendance.remove(checkoutDetail);
        checkoutDetail.setCheckout(null);
    }

    public void addProductDetail(CheckoutDetailProduct checkoutDetail) {
        checkoutDetailsProduct.add(checkoutDetail);
        checkoutDetail.setCheckout(this);
    }

    public void removeProductDetail(CheckoutDetailProduct checkoutDetail) {
        checkoutDetailsProduct.remove(checkoutDetail);
        checkoutDetail.setCheckout(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Checkout checkout = (Checkout) o;
        return
                Objects.equals(idCustomer, checkout.idCustomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer);
    }
}

