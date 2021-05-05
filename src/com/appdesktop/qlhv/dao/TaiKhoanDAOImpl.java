package com.appdesktop.qlhv.dao;

import com.appdesktop.qlhv.model.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaiKhoanDAOImpl implements TaiKhoanDAO{

    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT * FROM quanlihocvien.taikhoan WHERE tenDangNhap LIKE ? AND matKhau LIKE ?;";
        TaiKhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new TaiKhoan();
                taiKhoan.setMaTaiKhoan(rs.getInt("maTaiKhoan"));
                taiKhoan.setTenDangNhap(rs.getString("tenDangNhap"));
                taiKhoan.setMatKhau(rs.getString("matKhau"));
                taiKhoan.setTinhTrang(rs.getBoolean("tinhTrang"));
            }
            ps.close();
            cons.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
