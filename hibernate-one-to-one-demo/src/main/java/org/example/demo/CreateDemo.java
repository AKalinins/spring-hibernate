package org.example.demo;

import org.example.demo.domain.Instructor;
import org.example.demo.domain.InstructorDetail;
import org.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            Instructor instructor = new Instructor("John", "Smith", "john@smith.com");
            InstructorDetail instructorDetail = new InstructorDetail("johnsmith", "Movies");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            /*
                This saves instructors object AND instructorDetail object because
                of @OneToOne(cascade = CascadeType.ALL)
             */
            session.save(instructor);

            session.getTransaction().commit();
        }


    }
}
