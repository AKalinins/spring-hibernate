package com.example.demo.domain;

import javax.persistence.*;
import org.hibernate.annotations.Cascade;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    //Bi-directional many-to-one
    @ManyToOne(fetch = FetchType.LAZY,
            //No Remove type here, because instructor must not be deleted in case of course deletion
            cascade = {CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    //javax.persistence cascade for saving does not work in Hibernate for some reason
    //Use org.hibernate.annotations.CascadeType.SAVE_UPDATE for cascade saving
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Instructor instructor;

    //All reviews must be deleted in case course is deleted
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }

    public void addReview(Review review) {
        if (null == reviews) {
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }
}
