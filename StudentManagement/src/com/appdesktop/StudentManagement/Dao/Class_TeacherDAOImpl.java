package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Class_Teacher;
import com.appdesktop.StudentManagement.Model.studentOfClass;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Class_TeacherDAOImpl implements Class_TeacherDAO{

    @Override
    public List<Class_Teacher> getAllClassOfTeacher(String idTeacher) {
        String sql = "SELECT class_teacher.id_class_teacher,class_teacher.class_idclass, class.classname " +
                ", class_teacher.class_course_idcourse , course.coursename,class_teacher.status " +
                ", class_teacher.register_date " +
                " FROM ((class_teacher " +
                " INNER JOIN class ON class_teacher.class_idclass = class.idclass) " +
                " INNER JOIN course ON class_teacher.class_course_idcourse = course.idcourse) " +
                " Where class_teacher.teacher_idteacher = ?;";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) 
        {
            patmt.setString(1, idTeacher);
            try(ResultSet rs = patmt.executeQuery()) 
            {
                List<Class_Teacher> list = new ArrayList<>();
                while (rs.next()) {
                    Class_Teacher cTeacher = new Class_Teacher();
                    cTeacher.setId_class_teacher(rs.getString("id_class_teacher"));
                    cTeacher.setIdClass(rs.getString("class_idclass"));
                    cTeacher.setClassName(rs.getString("classname"));
                    cTeacher.setIdCourse(rs.getString("class_course_idcourse"));
                    cTeacher.setCourseName(rs.getString("coursename"));
                    cTeacher.setStatus(rs.getBoolean("status"));
                    cTeacher.setRegisterDate(rs.getDate("register_date"));
                    list.add(cTeacher);
                }   
                return list;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return null;
    }

    @Override
    public boolean deleteClassOfTeacher(String idClass, String idCourse, String idStudent) {
        String sql = "DELETE FROM class_teacher "
                + "WHERE class_idclass = ?  and class_course_idcourse = ? and teacher_idteacher = ?;";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idClass);
            patmt.setString(2, idCourse);
            patmt.setString(3, idStudent);
            return patmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registerClassOfTeacher(String idClass, String idCourse, String idteacher) {
        String sql = "INSERT INTO class_teacher(register_date, status, class_idclass, class_course_idcourse, "
                + "teacher_idteacher) values(?, ?, ?, ?, ?);";
        long millis = System.currentTimeMillis();   
        java.sql.Date date = new java.sql.Date(millis);   
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setDate(1, date);
            pstmt.setBoolean(2, true);
            pstmt.setString(3, idClass);
            pstmt.setString(4, idCourse);
            pstmt.setString(5, idteacher);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    @Override
    public String getNameTeacherOfClass(String idClass) {
        String sql = "SELECT teacher.tchname " +
            " FROM class_teacher " +
            " inner join teacher on class_teacher.teacher_idteacher = teacher.idteacher " +
            " where class_teacher.class_idclass = ?;";

        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idClass);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {                   
                    return rs.getString("tchname");
                }   
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return null;
    } 

    @Override
    public List<studentOfClass> getAllStudentOfClass(String idClass) {
        String sql = " SELECT class_student.student_idstudent, student.studentname,class_student.class_idclass, "
                + "class.classname, class_student.registerdate, class_student.class_course_idcourse FROM "
                + "class_student INNER JOIN student ON class_student.student_idstudent = student.idstudent "
                + "INNER JOIN class ON class_student.class_idclass = class.idclass INNER JOIN course ON "
                + "class_student.class_course_idcourse = course.idcourse WHERE class_student.class_idclass = ?";
        try(
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idClass);
            try(ResultSet rs = patmt.executeQuery()) {
                List<studentOfClass> list = new ArrayList<>();
                while (rs.next()) { 
                    studentOfClass stClass = new studentOfClass();
                    stClass.setIdStudent(rs.getString("student_idstudent"));
                    stClass.setNameStudent(rs.getString("studentname"));
                    stClass.setIdClass(rs.getString("class_idclass"));
                    stClass.setNameClass(rs.getString("classname"));
                    stClass.setRegisterdate(rs.getDate("registerdate"));
                    stClass.setIdCourse(rs.getString("class_course_idcourse"));
                    list.add(stClass);
                }   
                return list;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return null;
    }
}
