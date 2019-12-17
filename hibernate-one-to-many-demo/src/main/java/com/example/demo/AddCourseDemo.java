package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Instructor;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AddCourseDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 3);

            Course course1 = new Course("Java");
            Course course2 = new Course("SQL");
            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        }
    }
}
