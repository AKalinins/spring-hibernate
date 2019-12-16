package org.example.demo.dao.daoImpl;

import org.example.demo.dao.StudentDAO;
import org.example.demo.domain.Student;
import org.example.demo.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public void saveStudent(Student student) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Beginning transaction");
            session.beginTransaction();
            System.out.println("Saving student object");
            session.save(student);
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Committed successfully");
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public Student getStudentById(int id) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Beginning transaction");
            session.beginTransaction();
            System.out.println("Getting student object");
            Student student = session.get(Student.class, id);
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Committed successfully");
            return student;
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public List<Student> queryStudents(String queryString, String... params) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Beginning transaction");
            session.beginTransaction();
            System.out.println("Getting list of student object");
            Query query = session.createQuery(queryString, Student.class);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i + 1, params[i]);
                }
            }
            return query.getResultList();
        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public void updateStudentEmail(int id, String newEmail) {

        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Beginning transaction");
            session.beginTransaction();
            System.out.println("Getting student object");
            Student student = session.get(Student.class, id);
            student.setEmail(newEmail);
            System.out.println("Committing transaction");
            session.getTransaction().commit();
            System.out.println("Committed successfully");

        } finally {
            sessionFactory.close();
        }
    }

    @Override
    public void deleteStudent(String queryString, String... params) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            System.out.println("Beginning transaction");
            session.beginTransaction();
            Query query = session.createQuery(queryString);
            if (null != params) {
                for (int i = 0; i < params.length; i++) {
                    query.setParameter(i + 1, params[i]);
                }
            }
            query.executeUpdate();
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
