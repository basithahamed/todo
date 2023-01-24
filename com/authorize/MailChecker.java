package com.authorize;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MailChecker {
    public boolean isExsist(String email) throws ClassNotFoundException, SQLException {
        boolean result = false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://10.52.0.80:3306/tododata", "todoadmins", "todo@111");
        PreparedStatement ps;
        ResultSet rs;
        String sql = "select * from Users";
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while(rs.next()) {
            if(rs.getString("email").equals(email))
            {
                result=true;
                // connection.close();
            }
        }
        return result;
    }

    
}
