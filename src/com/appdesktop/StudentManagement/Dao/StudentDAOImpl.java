package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Person;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public List<Person> getAllStudent() {
        String sql = "select * from student_management.student";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            try(ResultSet rs = patmt.executeQuery()) {
                List<Person> list = new ArrayList<>();
                while (rs.next()) {
                    Person st = createStudent(rs);
                    list.add(st);
                }   
                return list;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
        return null;
    }
    private Person createStudent(final ResultSet rs) {
        try {
            Person st = new Person();
            st.setId(rs.getString("idstudent"));
            st.setName(rs.getString("stname"));
            st.setBrithday(rs.getDate("stbrithday"));
            st.setGender(rs.getBoolean("stgender"));
            st.setAddress(rs.getString("staddress"));
            st.setStatus(rs.getBoolean("ststatus"));
            st.setEmail(rs.getString("stemail"));
            st.setPhone(rs.getString("stphone"));

            Blob blob = rs.getBlob("stavatar");
            if (blob != null) {
                st.setAvatar(blob.getBytes(1, (int) blob.length()));
            }
            return st;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;    
    }

    @Override
    public Person getStudent(String idStudent) {
        String sql = "select * from student_management.student" +
                " where idstudent = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idStudent);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {
                    Person st = createStudent(rs);
                    return st;
                }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }

    @Override
    public boolean updateStudent(Person st) {
        String sql = "UPDATE student_management.student " + " SET stname = ?, stbrithday = ?, "
                + "stgender = ?, staddress = ?, ststatus = ?, stemail = ?, stphone = ?,  stavatar = ?" +
                " where idstudent = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(9, st.getId());
            patmt.setString(1, st.getName());
            patmt.setDate(2, (Date) st.getBrithday());
            patmt.setBoolean(3, st.isGender());
            patmt.setString(4, st.getAddress());
            patmt.setBoolean(5, st.isStatus());
            patmt.setString(6, st.getEmail());
            patmt.setString(7, st.getPhone());
            if (st.getAvatar() != null) {
                Blob avatar = new SerialBlob(st.getAvatar());
                System.out.println("Khac NULL");
                // pstmt
                patmt.setBlob(8, avatar);
            } else {
                Blob avatar = null;
                System.out.println("NULL");
                patmt.setBlob(8, avatar);
            }         
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean inserStudent(Person st) {
        String sql = "INSERT INTO student_management.student(idstudent, stname, stbrithday, stgender, "
                + "staddress, ststatus, stemail, stphone, stavatar, account_username)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(1, st.getId());
            pstmt.setString(2, st.getName());
            pstmt.setDate(3, new Date(st.getBrithday().getTime()));
            pstmt.setBoolean(4, st.isGender());
            pstmt.setString(5, st.getAddress());
            pstmt.setBoolean(6, st.isStatus());
            pstmt.setString(7, st.getEmail());
            pstmt.setString(8, st.getPhone());

            if (st.getAvatar()!= null) {
                Blob avatar = new SerialBlob(st.getAvatar());
                // pstmt
                pstmt.setBlob(9, avatar);
            } else {
                Blob avatar = null;
                pstmt.setBlob(9, avatar);
            }   
            pstmt.setString(10, st.getAccount_username());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }

    @Override
    public boolean deleteStudent(String idStudent) {
        String sql = "DELETE FROM `student_management`.`student` "
                + "WHERE (`idstudent` = ? ) and (`account_username` = ?);";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idStudent);
            patmt.setString(2, idStudent);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean updateProfile(Person ps) {
        String sql = "UPDATE student_management.student " + " SET stemail = ?, stphone = ?, stavatar = ?" +
                " where idstudent = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(4, ps.getId());
            pstmt.setString(1, ps.getEmail());
            pstmt.setString(2, ps.getPhone());
            if (ps.getAvatar()!= null) {
                Blob avatar = new SerialBlob(ps.getAvatar());
                // pstmt
                pstmt.setBlob(3, avatar);
            } else {
                Blob avatar = null;
                pstmt.setBlob(3, avatar);
            }         
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Person> getListExport() {
        try {
            Connection con = DBHelper.openConnection();
            String sql = "select * from student_management.student";
            List<Person> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person st = new Person();
                st.setId(rs.getString("idstudent"));
                st.setName(rs.getString("stname"));
                st.setBrithday(rs.getDate("stbrithday"));
                st.setGender(rs.getBoolean("stgender"));
                st.setAddress(rs.getString("staddress"));
                st.setStatus(rs.getBoolean("ststatus"));
                st.setEmail(rs.getString("stemail"));
                st.setPhone(rs.getString("stphone"));
                list.add(st);
            }
            ps.close();
            rs.close();
            con.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
