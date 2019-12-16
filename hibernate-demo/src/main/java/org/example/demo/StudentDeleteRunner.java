package org.example.demo;

import org.example.demo.dao.StudentDAO;
import org.example.demo.dao.daoImpl.StudentDAOImpl;

public class StudentDeleteRunner {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAOImpl();

        String query = "DELETE FROM Student s WHERE s.firstName = ?1";
        String[] params = new String[]{"test"};
        studentDAO.deleteStudent(query, params);
    }
}
