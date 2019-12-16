package org.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCTester {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "root";
        String pass = "root";

        try {
            System.out.println("Connecting to DB " + url);
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
