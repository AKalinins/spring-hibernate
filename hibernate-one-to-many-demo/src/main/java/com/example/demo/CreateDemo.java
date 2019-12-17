package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Instructor;
import com.example.demo.domain.InstructorDetail;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateDemo {

    public static void main(String[] args) {


        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            Instructor instructor = new Instructor("John", "Smith", "john@smith.com");
            InstructorDetail instructorDetail = new InstructorDetail("johnsmith", "Movies");
            instructor.setInstructorDetail(instructorDetail);

            Course course1 = new Course("Java");
            Course course2 = new Course("SQL");
            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();
        }


    }
}
