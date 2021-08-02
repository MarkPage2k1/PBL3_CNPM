package com.appdesktop.StudentManagement.DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBHelper {
    public static Connection openConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://localhost:3306/student_management";
            String DBUserName = "root";
            String password = "root";
            Connection con = DriverManager.getConnection(connectionUrl, DBUserName, password);
            return con;
        } catch(Exception e){
            //e.printStackTrace();
        }
        return null;
    }
}