package com.appdesktop.qlhv.dao;

import com.appdesktop.qlhv.bean.KhoaHocBean;
import com.appdesktop.qlhv.bean.LopHocBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MinhPhu
 */
public class ThongKeDAOImpl implements ThongKeDAO{

    @Override
    public List<LopHocBean> getListByLopHoc() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT ngayDangKy, COUNT(*) AS so_luong FROM quanlihocvien.lophoc GROUP BY ngayDangKy;";
        List<LopHocBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LopHocBean lopHocBean = new LopHocBean();
                lopHocBean.setNgay_dang_ky(rs.getString("ngayDangKy"));
                lopHocBean.setSo_luong_hoc_vien(rs.getInt("so_luong"));
                list.add(lopHocBean);
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
    public List<KhoaHocBean> getListByKhoaHoc() {
        Connection cons = DBConnect.getConnection();
        String sql = "SELECT tenKhoaHoc, ngayBatDau, ngayKetThuc FROM quanlihocvien.khoahoc WHERE tinhTrang = TRUE ORDER BY ngayBatDau ASC;";
        List<KhoaHocBean> list = new ArrayList<>();
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhoaHocBean khoaHocBean = new KhoaHocBean();
                khoaHocBean.setTen_khoa_hoc(rs.getString("tenKhoaHoc"));
                khoaHocBean.setNgay_bat_dau(rs.getDate("ngayBatDau"));
                khoaHocBean.setNgay_ket_thuc(rs.getDate("ngayKetThuc"));
                list.add(khoaHocBean);
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
