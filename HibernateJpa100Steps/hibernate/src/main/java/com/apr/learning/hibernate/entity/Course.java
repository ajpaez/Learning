package com.apr.learning.hibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COURSE")
@NamedQuery(name = "query_get_all", query = "Select  c  From Course c")
//@Cacheable //uncomment for com.apr.learning.hibernate.repository.CourseRepositoryTest.findByIdCheckSecondLevelCacheTest
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 300)
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Review> reviews;

    //For many-to-many, CascadeType.REMOVE is a terrible idea.
    //https://vladmihalcea.com/a-beginners-guide-to-jpa-and-hibernate-cascade-types/

    //The mappedBy attribute of the students association in the Course entity marks that, in this bidirectional relationship,
    //the Course entity owns the association. This is needed since only one side can own a relationship,
    //and changes are only propagated to the database from this particular side.
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Student> students;

    @UpdateTimestamp
    private LocalDateTime updatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course() {
        reviews = new ArrayList<>();
        this.students = new HashSet<>();
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

    public List<Review> getReviews() {
        return reviews;
    }

    //theses method are used to synchronize both sides of
    // the bidirectional association
    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public Set<Student> getStudents() {
        return students;
    }

    //theses method are used to synchronize both sides of
    // the bidirectional association
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        this.students.remove(student);
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
