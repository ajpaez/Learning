package com.apr.learning.jdbctojpa.jpa.entity;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "personjpa")
//REMEMBER: JPQL uses entities not tables to do the query
@NamedQuery(name="find_all_persons", query="select p from Person p")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "location")
    private String location;
    @Column(name = "birth")
    private Date birthDate;

    public Person() {
    }

    public Person(String name, String location, Date birthDate) {
        this.name = name;
        this.location = location;
        this.birthDate = birthDate;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", localtion='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
