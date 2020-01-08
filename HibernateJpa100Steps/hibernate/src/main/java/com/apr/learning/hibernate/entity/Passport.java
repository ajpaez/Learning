package com.apr.learning.hibernate.entity;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    private Long id;

    @Column(nullable = false)
    private String number;

    //The @OneToOne and the @JoinColumn annotations specify the association.
    //@OneToOne annotations are fetched EAGERly
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    //The @MapsId annotation tells Hibernate to use the primary key value of the Student entity as the primary key value of the Passport entity
    @MapsId
    private Student student;

    protected Passport() {
    }

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return String.format("Passport[%s]", number);
    }
}
