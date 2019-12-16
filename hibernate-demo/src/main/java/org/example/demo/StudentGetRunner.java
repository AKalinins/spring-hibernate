package org.example.demo;

import org.example.demo.dao.daoImpl.StudentDAOImpl;
import org.example.demo.domain.Student;

public class StudentGetRunner {

    public static void main(String[] args) {

        Student student = new StudentDAOImpl().getStudentById(1);
        System.out.println(student.toString());
    }
}
