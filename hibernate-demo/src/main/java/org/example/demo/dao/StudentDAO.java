package org.example.demo.dao;

import org.example.demo.domain.Student;

import java.util.List;

public interface StudentDAO {

    void saveStudent(Student student);
    Student getStudentById(int id);
    List<Student> queryStudents(String queryString, String... params);
    void updateStudentEmail(int id, String newEmail);
    void deleteStudent(String queryString, String... params);
}
