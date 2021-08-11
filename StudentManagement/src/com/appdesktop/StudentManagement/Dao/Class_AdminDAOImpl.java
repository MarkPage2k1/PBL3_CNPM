/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import com.appdesktop.StudentManagement.Model.Class_Admin;
import com.appdesktop.StudentManagement.Model.Class_Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duy Ngoc <duylengoc1111@gmail.com>
 */
public class Class_AdminDAOImpl implements Class_AdminDAO {

    private CourseDAOIpml courseDao = new CourseDAOIpml();
    private TeacherDAOImpl teacherDao = new TeacherDAOImpl();

    @Override
    public List<Class_Admin> getAll_ClassAdmin() {
        String query = "Select class_teacher.id_class_teacher ,class_teacher.class_idclass,"
                + "class.classname,course.coursename,tchname,class.statuss,"
                + "startdate,enddate from class_teacher inner join class on "
                + "class_teacher.class_idclass = class.idclass inner join teacher on "
                + "teacher.idteacher = class_teacher.teacher_idteacher "
                + "inner join course on course.idcourse = class_teacher.class_course_idcourse";
        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(query);) {
            try (ResultSet rs = patmt.executeQuery()) {
                List<Class_Admin> list = new ArrayList<Class_Admin>();
                while (rs.next()) {
                    Class_Admin class_admin = new Class_Admin();
                    class_admin.setId_class_teacher(rs.getString("id_class_teacher"));
                    class_admin.setId_class(rs.getString("class_idclass"));
                    class_admin.setClassname(rs.getString("classname"));
                    class_admin.setNamecourse(rs.getString("coursename"));
                    class_admin.setTeachername(rs.getString("tchname"));
                    class_admin.setStatus(rs.getBoolean("statuss"));
                    class_admin.setStartdate(rs.getDate("startdate"));
                    class_admin.setEnddate(rs.getDate("enddate"));
                    list.add(class_admin);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Class_Admin> getAll_ClassAdminbyID(String idCourse) {
        List<Class_Admin> list = new ArrayList<Class_Admin>();
        for (Class_Admin c_a : getAll_ClassAdmin()) {
            if (idCourse.equals("0") || idCourse.equals(courseDao.getIdCoursebyName(c_a.getNamecourse()))) {
                list.add(c_a);
            }
        }
        return list;
    }

    @Override
    public Class_Admin getClass_AdminByID(String idclass_admin) {
        Class_Admin class_admin = null;
        for (Class_Admin ca : getAll_ClassAdmin()) {
            if (idclass_admin.equals(ca.getId_class_teacher())) {
                class_admin = ca;
            }
        }
        return class_admin;
    }

    @Override
    public String getId_class_teacher(String idclass, String idcourse) {
        String id = null;
        for (Class_Admin ca : getAll_ClassAdmin()) {
            if (idclass.equals(ca.getId_class()) && idcourse.equals(courseDao.getIdCourse(ca.getNamecourse()))) {
                id = ca.getId_class_teacher();
                break;
            }
        }
        return id;
    }

    @Override
    public boolean InsertClass(String idClass, String idCourse, String idteacher) {
        String sql = "INSERT INTO class_teacher(register_date, status, class_idclass, class_course_idcourse, "
                + "teacher_idteacher) values(?, ?, ?, ?, ?);";
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);) {
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
    public boolean UpdateClass(String idClass, String idCourse, String idteacher, String id_class_teacher) {
        String sql = "Update class_teacher set register_date = ?,status = ?, class_idclass = ?"
                + ", class_course_idcourse = ?, teacher_idteacher = ? where id_class_teacher = ?";
        try (Connection con = DBHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(sql)) {
            long millis = System.currentTimeMillis();
            java.sql.Date date = new java.sql.Date(millis);
            pstm.setDate(1, date);
            pstm.setBoolean(2, true);
            pstm.setString(3, idClass);
            pstm.setString(4, idCourse);
            pstm.setString(5, idteacher);
            pstm.setString(6, id_class_teacher);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean DeleteClass(String idclass_teacher) {
        String query = "delete from Class_Teacher where id_class_teacher = ?";
        try (
                Connection con = DBHelper.openConnection();
                PreparedStatement pstm = con.prepareStatement(query);) {
            pstm.setString(1, idclass_teacher);
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
