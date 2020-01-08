package com.apr.learning.hibernate.inheritance.entity;


import javax.persistence.*;

//https://thoughts-on-java.org/complete-guide-inheritance-strategies-jpa-hibernate/

@Entity
/*********************************************************
 SINGLE_TABLE
// one table to store all type of employees with a column to indicate the type (DiscriminatorColumn)
// simple, all in one table. a lot of null in the rows.
// You can, therefore, not use not null constraints on any column that isn’t mapped to all entities.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employeeType")
**********************************************************/
/*********************************************************
 TABLE_PER_CLASS
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// each entity has its table
// depending on the amounts of records in both tables, this query might become a performance issue
// common columns repeated
 **********************************************************/

/*********************************************************
 JOINED
@Inheritance(strategy = InheritanceType.JOINED)
// A strategy in which fields that are specific to a subclass are mapped to a separate table than the fields
// that are common to the parent class, and a join is performed to instantiate the subclass.
// is good in term of the data base design.
// The tables of the subclasses are much smaller than in the table per class strategy. They hold only
// the columns specific for the mapped entity class and a primary key with the same value as the record in the table of the superclass.
// Each query of a subclass requires a join of the 2 tables to select the columns of all entity attributes.
// That increases the complexity of each query, but it also allows you to use not null constraints on subclass attributes and to ensure data integrity.
*********************************************************/
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 300)
    private String name;

    protected Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
