package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateDemo {

    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
             Session session = sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Course course1 = new Course("Java");
            Course course2 = new Course("SQL");
            Course course3 = new Course("Maven");

            session.save(course1);
            session.save(course2);
            session.save(course3);

            Student student1 = new Student("John", "Smith", "john@smith.com");
            Student student2 = new Student("Finn", "Mertens", "finn@time.com");

            course1.addStudent(student1);
            course1.addStudent(student2);
            course2.addStudent(student1);
            course3.addStudent(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
        }
    }
}
