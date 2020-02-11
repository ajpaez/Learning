package com.apr.learning.hibernate.generalization.entity;

import javax.persistence.Entity;

@Entity(name = "CreditAccount")
public class CreditAccount extends Account {

    private double creditLimit;

    public CreditAccount(String owner, double balance, double interestRate, double creditLimit) {
        super(owner, balance, interestRate);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}
