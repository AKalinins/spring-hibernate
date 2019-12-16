package org.example.demo;

import org.example.demo.dao.StudentDAO;
import org.example.demo.dao.daoImpl.StudentDAOImpl;

public class StudentUpdateRunner {

    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAOImpl();
        studentDAO.updateStudentEmail(1, "john123@smith.com");
    }
}
