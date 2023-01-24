package com.authorize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DetailsAdder {
    public void addDetails(String first_name, String last_name, String nick_name, String email, String password)
            throws ClassNotFoundException {
        try {
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://10.52.0.80/tododata";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "todoadmins",
                    "todo@111");
            String query = " insert into Users(first_name,last_name,nick_name,email,password)"
                    + " values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, first_name);
            preparedStmt.setString(2, last_name);
            preparedStmt.setString(3, nick_name);
            preparedStmt.setString(4, email);
            preparedStmt.setString(5, password);
            preparedStmt.execute();
            conn.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }
}

