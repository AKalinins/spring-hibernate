package com.example.demo.utils;

import com.example.demo.domain.Course;
import com.example.demo.domain.Instructor;
import com.example.demo.domain.InstructorDetail;
import com.example.demo.domain.Review;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();
    }
}
