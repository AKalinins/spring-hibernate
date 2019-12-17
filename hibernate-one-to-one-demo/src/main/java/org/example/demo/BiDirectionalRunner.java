package org.example.demo;

import org.example.demo.domain.InstructorDetail;
import org.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BiDirectionalRunner {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1);

            System.out.println(instructorDetail);
            System.out.println(instructorDetail.getInstructor());

        }
    }
}
