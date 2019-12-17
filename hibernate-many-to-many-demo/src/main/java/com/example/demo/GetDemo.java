package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Course course = session.get(Course.class, 10);

            System.out.println(course.getStudents());

            Student student = session.get(Student.class, 2);
            System.out.println();
            System.out.println(student.getCourses());
        }
    }
}
