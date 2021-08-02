package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO{

    @Override
    public Account login(String username, String password) {
        Connection con = DBHelper.openConnection();
        String sql = "select username, password, position from student_management.account " + 
                "where username = ? and password = ?";
        Account account = null;
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                    account = new Account();
                    account.setUsername(username);
                    account.setPosition(rs.getString("position"));
                    return account;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }        
        return null;
    }    

    @Override
    public boolean inserAcount(Account account) {
        String sql = "INSERT INTO student_management.account(username, password, position) values(?, ?, ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(1, account.getUsername());
            pstmt.setString(2, account.getPassword());
            pstmt.setString(3, account.getPosition());         
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    @Override
    public boolean deleteAcount(String username) {
        String sql = "delete from student_management.account" +
                " where username = ?";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, username);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(StudentDAOImpl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            return false;
        }
    }
}
