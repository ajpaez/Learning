package com.apr.learning.hibernate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    //student is the owner of the relationship
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "STUDENT_COURSE", //set the name for the relationship table created
            joinColumns = @JoinColumn(name = "student"),
            inverseJoinColumns = @JoinColumn(name = "course")
    )
    private Set<Course> courses;

    @Embedded
    private Address address;

    protected Student() {
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new HashSet<>();
    }

    public Student(String name) {
        this.name = name;
        this.courses = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    //theses method are used to synchronize both sides of
    // the bidirectional association
    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address+ '\'' +
                '}';
    }
}
