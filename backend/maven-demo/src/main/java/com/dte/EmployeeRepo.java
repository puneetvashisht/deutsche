package com.dte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepo {
    static final String DB_URL = "jdbc:mysql://localhost/lntdb";
   static final String USER = "root";
   static final String PASS = "rootroot";
   static final String QUERY = "SELECT id, name, salary FROM employee";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("id"));
    
            System.out.print(", Name: " + rs.getString("name"));
            System.out.println(", Salary: " + rs.getDouble("salary"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
