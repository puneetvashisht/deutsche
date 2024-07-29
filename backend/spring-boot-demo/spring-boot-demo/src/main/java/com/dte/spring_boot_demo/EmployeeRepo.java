package com.dte.spring_boot_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    static final String DB_URL = "jdbc:mysql://localhost/lntdb";
   static final String USER = "root";
   static final String PASS = "rootroot";
   static final String QUERY = "SELECT id, name, salary FROM employee";

   public List<Employee> fetchEmployees() {
      // Open a connection

      List<Employee> employees = new ArrayList<>();
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            int id = rs.getInt("id");
            System.out.print("ID: " + id);
    
            String name = rs.getString("name");
            System.out.print(", Name: " +name);

            Double salary = rs.getDouble("salary");
            System.out.println(", Salary: " + salary);
            employees.add(new Employee(name, id, salary));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
      return employees;
   }
}
