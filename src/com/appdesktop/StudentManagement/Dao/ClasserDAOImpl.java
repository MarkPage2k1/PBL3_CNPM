package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Classer;
//import com.appdesktop.StudentManagement.Model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClasserDAOImpl implements ClasserDAO{

    @Override
    public List<Classer> getAllClassOfCourse(String idCouse) {
        String sql = "select * from student_management.class where course_idcourse = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idCouse);
            try(ResultSet rs = patmt.executeQuery()) {
                List<Classer> list = new ArrayList<>();
                while (rs.next()) {
                    Classer classer = new Classer();
                    classer.setIdClass(rs.getString("idclass"));
                    classer.setClassName(rs.getString("classname"));
                    classer.setStatus(rs.getBoolean("status"));
                    classer.setRemark(rs.getString("remark"));
                    classer.setRegistrationdate(rs.getDate("registrationdate"));
                    classer.setCourse_idcourse(rs.getString("course_idcourse"));
                    list.add(classer);
                }   
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOIpml.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
    @Override
    public Classer getClass(String idClass){
        String sql = "select * from student_management.class where idclass = ?";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idClass);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {
                    Classer classer = new Classer();
                    classer.setIdClass(rs.getString("idclass"));
                    classer.setClassName(rs.getString("classname"));
                    classer.setStatus(rs.getBoolean("status"));
                    classer.setRemark(rs.getString("remark"));
                    classer.setRegistrationdate(rs.getDate("registrationdate"));
                    classer.setCourse_idcourse(rs.getString("course_idcourse"));
                    return classer;
                }                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOIpml.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }

    @Override
    public boolean updateInforClass(Classer classer, String idCourseOld) {
        String sql = "UPDATE student_management.class " + " SET classname = ?, status = ?, "
                + "remark = ?, registrationdate = ?, course_idcourse = ? where idclass = ? and course_idcourse = ?;";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(7, idCourseOld);
            patmt.setString(6, classer.getIdClass());
            patmt.setString(1, classer.getClassName());
            patmt.setBoolean(2, classer.isStatus());
            patmt.setString(3, classer.getRemark());
            patmt.setDate(4, (Date) classer.getRegistrationdate());
            patmt.setString(5, classer.getCourse_idcourse());           
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    @Override
    public boolean insertInforClass(Classer classer) {
        String sql = "INSERT INTO student_management.class(idclass, classname, status, remark, registrationdate, course_idcourse) "
                + " values(?, ?, ?, ?, ?, ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(1, classer.getIdClass());
            pstmt.setString(2, classer.getClassName());
            pstmt.setBoolean(3, classer.isStatus());
            pstmt.setString(4, classer.getRemark());
            pstmt.setDate(5, new Date(classer.getRegistrationdate().getTime()));
            pstmt.setString(6, classer.getCourse_idcourse());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }

    @Override
    public boolean deleteClass(String idClass, String idCourse) {
        String sql = "DELETE FROM `student_management`.`class` "
                + "WHERE (`idclass` = ? ) and (`course_idcourse` = ?) ;";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idClass);
            patmt.setString(2, idCourse);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
