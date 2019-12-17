package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Instructor;
import com.example.demo.domain.InstructorDetail;
import com.example.demo.domain.Review;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CourseReviewDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor = new Instructor("John", "Smith", "john@smith.com");
            InstructorDetail instructorDetail = new InstructorDetail("johnsmith", "Movies");
            instructor.setInstructorDetail(instructorDetail);

            Course course1 = new Course("Java");
            Course course2 = new Course("SQL");
            instructor.addCourse(course1);
            instructor.addCourse(course2);

            Review review1 = new Review("1");
            Review review2 = new Review("2");
            Review review3 = new Review("3");

            course1.addReview(review1);
            course2.addReview(review2);
            course2.addReview(review3);

            session.save(instructor);

            session.getTransaction().commit();
        }
    }
}
