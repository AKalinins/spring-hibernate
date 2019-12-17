package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Instructor;
import com.example.demo.domain.InstructorDetail;
import com.example.demo.domain.Review;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReviewDeletionDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            //Course and reviews must be deleted
            Course course = session.get(Course.class, 14);
            session.delete(course);

            course = session.get(Course.class, 15);
            Review review = course.getReviews().get(0);
            course.getReviews().remove(review);
            session.delete(review);

            session.getTransaction().commit();
        }
    }
}
