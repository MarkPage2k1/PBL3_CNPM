package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Class_Student;
import com.appdesktop.StudentManagement.Service.Class_TeacherService;
import com.appdesktop.StudentManagement.Service.Class_TeacherServiceImpl;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Class_StudentDAOImpl implements Class_StudentDAO{

    @Override
    public List<Class_Student> getAllClassOfTeachers(String idCourse) {
                String sql = "SELECT student_management.class_teacher.class_idclass, student_management.class.classname " +
                ", student_management.class_teacher.class_course_idcourse, student_management.course.coursename " +
                ", student_management.teacher.tchname,  student_management.class.remark " +
                ", student_management.class_teacher.status, student_management.class_teacher.register_date " +         
                " FROM (((student_management.class_teacher " +
                " INNER JOIN student_management.class ON student_management.class_teacher.class_idclass = student_management.class.idclass) " + 
                " INNER JOIN student_management.course ON student_management.class_teacher.class_course_idcourse = student_management.course.idcourse) " +
                " INNER JOIN student_management.teacher ON student_management.class_teacher.teacher_idteacher = student_management.teacher.idteacher) " +
                " Where student_management.class_teacher.class_course_idcourse = ?;";

        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idCourse);
            try(ResultSet rs = patmt.executeQuery()) {
                List<Class_Student> list = new ArrayList<>();
                while (rs.next()) {
                    Class_Student cStudent = new Class_Student();
                    cStudent.setIdClass(rs.getString("class_idclass"));
                    cStudent.setClassName(rs.getString("classname"));
                    cStudent.setIdCourse(rs.getString("class_course_idcourse"));
                    cStudent.setCourseName(rs.getString("coursename"));
                    cStudent.setTchName(rs.getString("tchname"));
                    cStudent.setRemark(rs.getString("remark"));
                    cStudent.setStatus(rs.getBoolean("status"));
                    cStudent.setRegisterDate(rs.getDate("register_date"));
                    list.add(cStudent);
                }   
                return list;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return null;
    }

    @Override
    public List<Class_Student> getAllClassOfStudent(String idStudent) {
        String sql = "SELECT student_management.class_student.class_idclass, student_management.class.classname " +
                ", student_management.class_student.class_course_idcourse, student_management.course.coursename " +
                ", student_management.class.remark " +
                ", student_management.class_student.status, student_management.class_student.registerdate " +         
                " FROM ((student_management.class_student " +
                " INNER JOIN student_management.class ON student_management.class_student.class_idclass = student_management.class.idclass) " + 
                " INNER JOIN student_management.course ON student_management.class_student.class_course_idcourse = student_management.course.idcourse) " +
                " where student_management.class_student.student_idstudent = ?;";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idStudent);
            try(ResultSet rs = patmt.executeQuery()) {
                List<Class_Student> list = new ArrayList<>();
                Class_TeacherService cTeacherService = new Class_TeacherServiceImpl();
                String nameTeacher = null;
                while (rs.next()) {
                    Class_Student cStudent = new Class_Student();
                    cStudent.setIdClass(rs.getString("class_idclass"));
                    cStudent.setClassName(rs.getString("classname"));
                    cStudent.setIdCourse(rs.getString("class_course_idcourse"));
                    cStudent.setCourseName(rs.getString("coursename"));
                    nameTeacher = cTeacherService.getNameTeacherOfClass(rs.getString("class_idclass"));
                    cStudent.setTchName(nameTeacher);
                    cStudent.setRemark(rs.getString("remark"));
                    cStudent.setStatus(rs.getBoolean("status"));
                    cStudent.setRegisterDate(rs.getDate("registerdate"));
                    list.add(cStudent);
                }   
                return list;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return null;
    }

    @Override
    public boolean registerClassOfStudent(String idClass, String idCourse, String idStudent) {
        String sql = "INSERT INTO student_management.class_student(registerdate, status, student_idstudent, class_idclass, class_course_idcourse) "
                + " values(?, ?, ?, ?, ?);";
        long millis = System.currentTimeMillis();   
        java.sql.Date date = new java.sql.Date(millis);   
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            
            pstmt.setDate(1, date);
            pstmt.setBoolean(2, true);
            pstmt.setString(3, idStudent);
            pstmt.setString(4, idClass);
            pstmt.setString(5, idCourse);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    @Override
    public boolean deleteClassOfTeacher(String idClass, String idCourse, String idStudent) {
        String sql = "DELETE FROM student_management.class_student "
                + "WHERE (`student_idstudent` = ?) and (`class_idclass` = ?) and (`class_course_idcourse` = ?);";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idStudent);
            patmt.setString(2, idClass);
            patmt.setString(3, idCourse);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
