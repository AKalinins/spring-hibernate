package com.example.demo.utils;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    public static SessionFactory getSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }
}
