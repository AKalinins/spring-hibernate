package org.example.demo;

import org.example.demo.dao.StudentDAO;
import org.example.demo.dao.daoImpl.StudentDAOImpl;
import org.example.demo.domain.Student;

public class StudentSaveRunner {

    public static void main(String[] args) {

        System.out.println("Creating a new Student object");
        Student student = new Student("test", "Smith", "samanthf@smith.com");
        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.saveStudent(student);
    }
}
