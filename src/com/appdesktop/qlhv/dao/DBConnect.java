package com.appdesktop.qlhv.dao;

import java.sql.*;

public class DBConnect {
    
    public static Connection getConnection() {
        try {
            Connection con = null;
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlihocvien", "root", "root");
            return con;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) throws SQLException {
        Connection c = getConnection();
        System.out.println(c.toString());
        c.close();
    }
}
