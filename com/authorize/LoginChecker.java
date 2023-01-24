package com.authorize;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;






public class LoginChecker {

    public boolean validater(String email,String password) throws SQLException, ClassNotFoundException {
        // creating a prepare statement
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.52.0.80:3306/tododata", "todoadmins", "todo@111");
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from Users";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        boolean result=false;
        while(rs.next()) {
            if(rs.getString("email").equals(email)&& rs.getString("password").equals(password))
            {
                System.out.println("login access");
                return true;
            }
        }
        return result;
    }

    
}
