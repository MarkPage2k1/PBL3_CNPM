/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.qlhv.dao;

import com.appdesktop.qlhv.model.HocVien;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhPhu
 */
public class HocVienDAOImpl implements HocVienDAO{

    @Override
    public List<HocVien> getList() {
        
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "SELECT * FROM quanlihocvien.hocvien;";
            List<HocVien> list = new ArrayList<>();
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HocVien hocVien = new HocVien();
                hocVien.setMaHocVien(rs.getInt("maHocVien"));
                hocVien.setHoTen(rs.getString("hoTen"));
                hocVien.setSoDienThoai(rs.getString("soDienThoai"));
                hocVien.setDiaChi(rs.getString("diaChi"));
                hocVien.setNgaySinh(rs.getDate("ngaySinh"));
                hocVien.setGioiTinh(rs.getBoolean("gioiTinh"));
                hocVien.setTinhTrang(rs.getBoolean("tinhTrang"));
                list.add(hocVien);
            }
            ps.close();
            rs.close();
            cons.close();
            return list;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
     
    @Override
    public int createOrUpdate(HocVien hocVien) {
        try {
            Connection cons = DBConnect.getConnection();
            String sql = "INSERT INTO hocvien(maHocVien, hoTen, ngaySinh, gioiTinh, soDienThoai, diaChi, tinhTrang) VALUES(?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE hoTen = VALUES(hoTen), ngaySinh = VALUES(ngaySinh), gioiTinh = VALUES(gioiTinh), soDienThoai = VALUES(soDienThoai), diaChi = VALUES(diaChi), tinhTrang = VALUES(tinhTrang);";
            PreparedStatement ps = cons.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, hocVien.getMaHocVien());
            ps.setString(2, hocVien.getHoTen());
            ps.setDate(3, new Date(hocVien.getNgaySinh().getTime()));
            ps.setBoolean(4, hocVien.isGioiTinh());
            ps.setString(5, hocVien.getSoDienThoai());
            ps.setString(6, hocVien.getDiaChi());
            ps.setBoolean(7, hocVien.isTinhTrang());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int generatedKey = -1;
            
            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }
            ps.close();
            cons.close();
            return generatedKey;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    public static void main(String[] args) {
        HocVienDAO hocVienDAO = new HocVienDAOImpl();
        System.out.println(hocVienDAO.getList());
    }
}
