package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Course;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseDAOIpml implements CourseDAO{

    @Override
    public List<Course> getAllCourses() {
        String sql = "select * from student_management.course";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            try(ResultSet rs = patmt.executeQuery()) {
                List<Course> list = new ArrayList<>();
                while (rs.next()) {
                    Course course = new Course();
                    course.setIdCourse(rs.getString("idcourse"));
                    course.setCourseName(rs.getString("coursename"));
                    course.setDescribe(rs.getString("describe"));
                    course.setStartDate(rs.getDate("startdate"));
                    course.setEndDate(rs.getDate("enddate"));
                    course.setStatus(rs.getBoolean("status"));
                    list.add(course);
                }   
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOIpml.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }

    @Override
    public Course getCourse(String idCourse) {
        String sql = "select * from student_management.course where idcourse = ?";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idCourse);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {
                    Course course = new Course();
                    course.setIdCourse(rs.getString("idcourse"));
                    course.setCourseName(rs.getString("coursename"));
                    course.setDescribe(rs.getString("describe"));
                    course.setStartDate(rs.getDate("startdate"));
                    course.setEndDate(rs.getDate("enddate"));
                    course.setStatus(rs.getBoolean("status"));
                    return course;
                }                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOIpml.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }


    @Override
    public boolean updateInforCourse(Course course) {
        String sql = "UPDATE `student_management`.`course` SET `coursename` = ?, `describe` = ?, `startdate` = ?, `enddate` = ?, `status` = ? WHERE (`idcourse` = ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(6, course.getIdCourse());
            patmt.setString(1, course.getCourseName());
            patmt.setString(2, course.getDescribe());
            patmt.setDate(3, (Date) course.getStartDate());
            patmt.setDate(4, (Date) course.getEndDate());
            patmt.setBoolean(5, course.isStatus());          
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    @Override
    public boolean insertInforCourse(Course course) {
        String sql = "INSERT INTO student_management.course(student_management.course.idcourse, student_management.course.coursename, student_management.course.describe, student_management.course.startdate, student_management.course.enddate, student_management.course.status) \n" +
"                values(?, ?, ?, ?, ?, ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(1, course.getIdCourse());
            pstmt.setString(2, course.getCourseName());
            pstmt.setString(3, course.getDescribe());
            pstmt.setDate(4, new Date(course.getStartDate().getTime()));
            pstmt.setDate(5, new Date(course.getEndDate().getTime()));
            pstmt.setBoolean(6, course.isStatus());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }

    @Override
    public boolean deleteCourse(String idCourse) {
        String sql = "DELETE FROM `student_management`.`course` "
                + "WHERE (`idcourse` = ? );";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idCourse);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TeacherDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
