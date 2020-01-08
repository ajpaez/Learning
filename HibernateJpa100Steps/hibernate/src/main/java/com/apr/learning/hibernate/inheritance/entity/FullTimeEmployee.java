package com.apr.learning.hibernate.inheritance.entity;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class FullTimeEmployee extends Employee{

    protected FullTimeEmployee(){};

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    private BigDecimal salary;

}
