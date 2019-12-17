package org.example.demo;

import org.example.demo.domain.Instructor;
import org.example.demo.domain.InstructorDetail;
import org.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            Instructor instructor = new Instructor("test", "test", "john@smith.com");
            InstructorDetail instructorDetail = new InstructorDetail("test", "Movies");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            /*
                This saves instructors object AND instructorDetail object because
                of @OneToOne(cascade = CascadeType.ALL)
             */
            session.save(instructor);
            session.getTransaction().commit();

            System.out.println("Deletion");
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.delete(instructor);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
