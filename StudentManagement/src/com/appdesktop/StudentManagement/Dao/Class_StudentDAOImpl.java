package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Class_Student;
import com.appdesktop.StudentManagement.Model.ListStudent;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Class_StudentDAOImpl implements Class_StudentDAO {

    @Override
    public List<Class_Student> getAllClassOfTeachers(String idCourse) {
        String sql = "SELECT class_teacher.class_idclass, class.classname "
                + ", class_teacher.class_course_idcourse, course.coursename "
                + ", teacher.tchname,  class.remark "
                + ", class_teacher.status, class_teacher.register_date "
                + " FROM (((class_teacher "
                + " INNER JOIN class ON class_teacher.class_idclass = class.idclass) "
                + " INNER JOIN course ON class_teacher.class_course_idcourse = course.idcourse) "
                + " INNER JOIN teacher ON class_teacher.teacher_idteacher = teacher.idteacher) "
                + " Where class_teacher.class_course_idcourse = ?;";

        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);) {
            patmt.setString(1, idCourse);
            try (ResultSet rs = patmt.executeQuery()) {
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
        String sql = "SELECT class_student.id_class_student,class_student.class_idclass, class.classname "
                + ", class_student.class_course_idcourse, course.coursename "
                + ", class.remark "
                + ", class_student.status, class_student.registerdate "
                + " FROM ((class_student "
                + " INNER JOIN class ON class_student.class_idclass = class.idclass) "
                + " INNER JOIN course ON class_student.class_course_idcourse = course.idcourse) "
                + " where class_student.student_idstudent = ?;";
        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);) {
            patmt.setString(1, idStudent);
            try (ResultSet rs = patmt.executeQuery()) {
                List<Class_Student> list = new ArrayList<>();
                Class_TeacherDAO cTeacherDao = new Class_TeacherDAOImpl();
                String nameTeacher = null;
                while (rs.next()) {
                    Class_Student cStudent = new Class_Student();
                    cStudent.setId_class_student(rs.getString("id_class_student"));
                    cStudent.setIdClass(rs.getString("class_idclass"));
                    cStudent.setClassName(rs.getString("classname"));
                    cStudent.setIdCourse(rs.getString("class_course_idcourse"));
                    cStudent.setCourseName(rs.getString("coursename"));
                    nameTeacher = cTeacherDao.getNameTeacherOfClass(rs.getString("class_idclass"));
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
        String sql = "INSERT INTO class_student(registerdate, status, student_idstudent,"
                + " class_idclass, class_course_idcourse,id_class_student) "
                + " values(?, ?, ?, ?, ?, ?);";
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
            Class_AdminDAO class_adminDao = new Class_AdminDAOImpl();
            pstmt.setDate(1, date);
            pstmt.setBoolean(2, true);
            pstmt.setString(3, idStudent);
            pstmt.setString(4, idClass);
            pstmt.setString(5, idCourse);
            pstmt.setString(6,class_adminDao.getId_class_teacher(idClass, idCourse));
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ListStudent> getAllStudent(String id_class_teacher) {
        String sql = "Select class_student.class_idclass, class.classname, class_student.student_idstudent,student.studentname,student.stphone, \n" +
"course.coursename from class_student inner join class_teacher on class_student.id_class_student = class_teacher.id_class_teacher inner join class\n" +
"on class_student.class_idclass = class.idclass inner join student on class_student.student_idstudent = student.idstudent inner join course\n" +
"on class_student.class_course_idcourse = course.idcourse where class_teacher.id_class_teacher = ?";
        try (Connection con = DBHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql);) {
            pstm.setString(1, id_class_teacher);
//            pstm.setString(2, idcourse);
//            pstm.setString(3, idTeacher);
            try (ResultSet rs = pstm.executeQuery()) {
                List<ListStudent> list = new ArrayList<>();
                while (rs.next()) {
                    ListStudent Stlist = new ListStudent();
                    Stlist.setIdclass(rs.getString("class_idclass"));
                    Stlist.setClassname(rs.getString("classname"));
                    Stlist.setId_student(rs.getString("student_idstudent"));
                    Stlist.setNamestudent(rs.getString("studentname"));
                    Stlist.setPhonenumb(rs.getString("stphone"));
                    Stlist.setCoursename(rs.getString("coursename"));
                    list.add(Stlist);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteClassOfTeacher(String idClass, String idCourse, String idStudent) {
        String sql = "DELETE FROM class_student "
                + "WHERE student_idstudent = ? and class_idclass = ? and class_course_idcourse = ?;";
        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);) {
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
