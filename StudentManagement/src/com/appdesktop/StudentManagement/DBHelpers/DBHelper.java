package com.appdesktop.StudentManagement.DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBHelper {
    public static Connection openConnection(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://127.0.0.1:50695; DatabaseName = StudentManagement";
            String DBUserName = "sa";
            String password = "125900";
            Connection con = DriverManager.getConnection(connectionUrl, DBUserName, password);
            return con;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}