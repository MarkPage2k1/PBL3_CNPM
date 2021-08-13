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

public class TeacherDAOImpl implements TeacherDAO{

    @Override
    public Person getTeacher(String idTeacher) {
        String sql = "select * from teacher" +
                " where idteacher = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idTeacher);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {
                    Person teacher = createTeacher(rs);
                    return teacher;
                }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;

    }
    private Person createTeacher(final ResultSet rs) throws SQLException {
        Person ps = new Person();
        ps.setId(rs.getString("idteacher"));
        ps.setName(rs.getString("tchname"));
        ps.setBrithday(rs.getDate("tchbirthday"));
        ps.setGender(rs.getBoolean("tchgender"));
        ps.setAddress(rs.getString("tchaddress"));
        ps.setStatus(rs.getBoolean("tchstatus"));
        ps.setEmail(rs.getString("tchemail"));
        ps.setPhone(rs.getString("tchphone"));
        ps.setAvatar(rs.getBytes("tchavatar"));
//        Blob blob = rs.getBlob("tchavatar");
//        if (blob != null) {
//            ps.setAvatar(blob.getBytes(1, (int) blob.length()));
//        }
        return ps;
    }

    @Override
    public boolean updateProfile(Person ps) {
        String sql = "UPDATE teacher " + " SET tchemail = ?, tchphone = ?, tchavatar = ?" +
                " where idteacher = ?";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(4, ps.getId());
            pstmt.setString(1, ps.getEmail());
            pstmt.setString(2, ps.getPhone());
            pstmt.setBytes(3, ps.getAvatar());
//            if (ps.getAvatar()!= null) {
//                Blob avatar = new SerialBlob(ps.getAvatar());
//                // pstmt
//                pstmt.setBlob(3, avatar);
//            } else {
//                Blob avatar = null;
//                pstmt.setBlob(3, avatar);
//            }         
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateTeacher(Person teacher) {
        String sql = "UPDATE teacher " + " SET tchname = ?, tchbrithday = ?, "
                + "tchgender = ?, tchaddress = ?, tchstatus = ?, tchemail = ?, tchphone = ?,  tchavatar = ?" +
                " where idteacher = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(9, teacher.getId());
            patmt.setString(1, teacher.getName());
            patmt.setDate(2, (Date) teacher.getBrithday());
            patmt.setBoolean(3, teacher.isGender());
            patmt.setString(4, teacher.getAddress());
            patmt.setBoolean(5, teacher.isStatus());
            patmt.setString(6, teacher.getEmail());
            patmt.setString(7, teacher.getPhone());
            patmt.setBytes(8,teacher.getAvatar());
//            if (teacher.getAvatar() != null) {
//                Blob avatar = new SerialBlob(teacher.getAvatar());
//                patmt.setBlob(8, avatar);
//            } else {
//                Blob avatar = null;
//                patmt.setBlob(8, avatar);
//            }         
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean inserTeacher(Person teacher) {
        String sql = "INSERT INTO teacher(idteacher, tchname, tchbirthday, tchgender, "
                + "tchaddress, tchstatus, tchemail, tchphone, tchavatar, tchaccount)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(1, teacher.getId());
            pstmt.setString(2, teacher.getName());
            pstmt.setDate(3, new Date(teacher.getBrithday().getTime()));
            pstmt.setBoolean(4, teacher.isGender());
            pstmt.setString(5, teacher.getAddress());
            pstmt.setBoolean(6, teacher.isStatus());
            pstmt.setString(7, teacher.getEmail());
            pstmt.setString(8, teacher.getPhone());
            pstmt.setBytes(9, teacher.getAvatar());
//            if (teacher.getAvatar()!= null) {
//                Blob avatar = new SerialBlob(teacher.getAvatar());
//                pstmt.setBlob(9, avatar);
//            } else {
//                Blob avatar = null;
//                pstmt.setBlob(9, avatar);
//            }   
            pstmt.setString(10, teacher.getAccount_username());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }

    @Override
    public boolean deleteTeacher(String idTeacher) {
        String sql = "DELETE FROM teacher "
                + "WHERE idteacher = ?  and tchaccount = ?;";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idTeacher);
            patmt.setString(2, idTeacher);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Person> getAllTeacher() {
        String sql = "select * from teacher";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            try(ResultSet rs = patmt.executeQuery()) {
                List<Person> list = new ArrayList<>();
                while (rs.next()) {
                    Person tch = createTeacher(rs);
                    list.add(tch);
                }   
                return list;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
        return null;
    }
    public String getIdTeacherByName(String nametch)
    {
        String st = null;
        for(Person tch : getAllTeacher())
        {
            if(nametch.equals(tch.getName()))
            {
                st = tch.getId();
                break;
            }
        }
        return st;
    }
    @Override
    public String getIdTeacher(String Teachername) {
        String id = null;
        for(Person ps : getAllTeacher())
        {
            if(Teachername.equals(ps.getName()))
            {
                id = ps.getId();
                break;
            }
        }
        return id;
    }
}
