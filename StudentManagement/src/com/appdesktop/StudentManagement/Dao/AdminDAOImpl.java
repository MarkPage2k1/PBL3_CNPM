package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Person;
import java.io.ByteArrayOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

public class AdminDAOImpl implements AdminDAO{

    @Override
    public Person getAdmin(String idAdmin) {
        String sql = "select * from admin" +
                " where idadmin = ?";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement patmt = con.prepareStatement(sql);
           ) {
            patmt.setString(1, idAdmin);
            try(ResultSet rs = patmt.executeQuery()) {
                if (rs.next()) {
                    Person st = createAdmin(rs);
                    return st;
                }   
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return null;
    }
    
    private Person createAdmin(final ResultSet rs) {
        try {
            Person st = new Person();
            st.setId(rs.getString("idadmin"));
            st.setName(rs.getString("adminname"));
            st.setBrithday(rs.getDate("adbirthday"));
            st.setGender(rs.getBoolean("adgender"));
            st.setAddress(rs.getString("adaddress"));
            st.setStatus(rs.getBoolean("adstatus"));
            st.setEmail(rs.getString("ademail"));
            st.setPhone(rs.getString("adphone"));
            st.setAvatar(rs.getBytes("adavatar"));
//            Blob blob = rs.getBlob("adavatar");
//            if (blob != null) {
//                st.setAvatar(blob.getBytes(1, (int) blob.length()));
//            }
            return st;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;    
    }

    @Override
    public boolean updateProfile(Person ps) 
    {
        String sql = "UPDATE admin " + " SET ademail = ?, adphone = ?, adavatar = ?" +
                " where idadmin = ?";
        try(
                Connection con = com.appdesktop.StudentManagement.DBHelpers.DBHelper.openConnection();
                PreparedStatement pstmt = con.prepareStatement(sql);
           ) {
            pstmt.setString(4, ps.getId());
            pstmt.setString(1, ps.getEmail());
            pstmt.setString(2, ps.getPhone());
            pstmt.setBytes(3, ps.getAvatar());
//            if (ps.getAvatar()!= null) 
//            {
//                Blob avatar = new SerialBlob(ps.getAvatar());
//                // pstmt
//                pstmt.setBlob(3, avatar);
//            } 
//            else 
//            {
//                Blob avatar = null;
//                pstmt.setBlob(3, avatar);
//            }         
            return pstmt.executeUpdate() > 0;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(AdminDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
