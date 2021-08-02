package com.appdesktop.StudentManagement.Dao;

// import com.appdesktop.StudentManagement.Model.Course;
import com.appdesktop.StudentManagement.Model.Mark;
import java.sql.Connection;
// import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MarkDaoImpl implements MarkDao{

    @Override
    public boolean inserMarkOfStudent(Mark mark) {
            String sql = "INSERT INTO `student_management`.`mark` (`mark1`, `mark2`, `mark3`, `course_idcourse`, `student_idstudent`) "
                    + "VALUES (?, ?, ?, ?, ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setDouble(1, mark.getMark1());
            pstmt.setDouble(2, mark.getMark2());
            pstmt.setDouble(3, mark.getMark3());
            pstmt.setString(4, mark.getIdCourse());
            pstmt.setString(5, mark.getIdStudent());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MarkDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }      
    }

    @Override
    public boolean updateMarkOfStudent(Mark mark) {
        String sql = "UPDATE `student_management`.`mark` SET `mark1` = ?, `mark2` = ?, `mark3` = ?  WHERE (`course_idcourse` = ?) and (`student_idstudent` = ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setDouble(1, mark.getMark1());
            pstmt.setDouble(2, mark.getMark2());
            pstmt.setDouble(3, mark.getMark3());
            pstmt.setString(4, mark.getIdCourse());
            pstmt.setString(5, mark.getIdStudent());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }      
    }

    @Override
    public Mark getMarkOfStudent(String idCourse, String idStudent) {
        String sql = "SELECT  student_management.mark.mark1, student_management.mark.mark2, student_management.mark.mark3 From student_management.mark  " + 
        " where (student_management.mark.student_idstudent = ? and student_management.mark.course_idcourse = ?);";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idStudent);
            patmt.setString(2, idCourse);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {
                    Mark mark = new Mark();
                    mark.setMark1(rs.getDouble("mark1"));
                    mark.setMark2(rs.getDouble("mark2"));
                    mark.setMark3(rs.getDouble("mark3"));
                    return mark;
                }                  
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return null;
    }
    
}
