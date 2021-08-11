package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Bean.ClassBean;
import com.appdesktop.StudentManagement.Bean.CourseBean;
import com.appdesktop.StudentManagement.DBHelpers.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalytisDAOImpl implements AnalytisDAO {

    @Override
    public List<ClassBean> getListByClass() {
        Connection cons = null;
        try {
            cons = DBHelper.openConnection();
        } catch (Exception ex) {
            Logger.getLogger(AnalytisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT registerdate, COUNT(*) AS numberOfStudents FROM class_student GROUP BY registerdate order by registerdate ASC;";
        List<ClassBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClassBean classBean = new ClassBean();
                classBean.setRegistrationDate(rs.getString("registerdate"));
                classBean.setNumberOfParticipants(rs.getInt("numberOfStudents"));
                list.add(classBean);
             }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CourseBean> getListByCourse() {
        Connection cons = null;
        try {
            cons = DBHelper.openConnection();
        } catch (Exception ex) {
            Logger.getLogger(AnalytisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql = "SELECT coursename, startdate, enddate FROM course WHERE statuss = 1 ORDER BY enddate ASC;";
        List<CourseBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                CourseBean courseBean = new CourseBean();
                courseBean.setCourseName(rs.getString("coursename"));
                courseBean.setStartDate(rs.getDate("startdate"));
                courseBean.setEndDate(rs.getDate("enddate"));
                list.add(courseBean);
            }
            ps.close();
            cons.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
