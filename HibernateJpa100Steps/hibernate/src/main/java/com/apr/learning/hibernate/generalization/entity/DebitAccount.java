package com.apr.learning.hibernate.generalization.entity;

import javax.persistence.Entity;

@Entity(name = "DebitAccount")
public class DebitAccount extends Account {

    private double overdraftFee;

    public DebitAccount(String owner, double balance, double interestRate, double overdraftFee) {
        super(owner, balance, interestRate);
        this.overdraftFee = overdraftFee;
    }

    public double getOverdraftFee() {
        return overdraftFee;
    }

    public void setOverdraftFee(double overdraftFee) {
        this.overdraftFee = overdraftFee;
    }
}
