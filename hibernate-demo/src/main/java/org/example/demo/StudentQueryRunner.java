package org.example.demo;

import org.example.demo.dao.StudentDAO;
import org.example.demo.dao.daoImpl.StudentDAOImpl;
import org.example.demo.domain.Student;

import java.util.List;

public class StudentQueryRunner {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAOImpl();

        String query =  "FROM Student s WHERE s.lastName = ?1";
        String[] params = {"Smith"};
        List<Student> studentList = studentDAO.queryStudents(query, params);
        for (Student student : studentList) {
            System.out.println(student);
        }

        query = "From Student s WHERE s.email LIKE ?1";
        params[0] = "%@parker%";
        studentList = studentDAO.queryStudents(query, params);
        for (Student student : studentList) {
            System.out.println(student);
        }

        query = "From Student s WHERE s.firstName = ?1 OR s.firstName = ?2";
        params = new String[]{"Samantha", "Mary"};
        studentList = studentDAO.queryStudents(query, params);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}
