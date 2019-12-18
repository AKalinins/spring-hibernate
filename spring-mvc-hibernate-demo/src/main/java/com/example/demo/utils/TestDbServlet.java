package com.example.demo.utils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/testDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String user = "root";
        String pass = "root";

        try (PrintWriter writer = response.getWriter();
             Connection connection = DriverManager.getConnection(jdbcUrl, user, pass)) {

            writer.println("Connecting to " + jdbcUrl);

            writer.println("Success!");

        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
