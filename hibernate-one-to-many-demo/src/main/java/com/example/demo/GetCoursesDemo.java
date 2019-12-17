package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Instructor;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GetCoursesDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 3);

            System.out.println("Break here to see LAZY fetch");

            List<Course> courseList = instructor.getCourses();
            System.out.println(courseList);

        }
    }
}
