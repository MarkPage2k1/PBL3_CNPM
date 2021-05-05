package com.appdesktop.qlhv.service;

import com.appdesktop.qlhv.dao.TaiKhoanDAO;
import com.appdesktop.qlhv.dao.TaiKhoanDAOImpl;
import com.appdesktop.qlhv.model.TaiKhoan;

public class TaiKhoanServiceImpl implements TaiKhoanService{

    private TaiKhoanDAO taiKhoanDAO = null;

    public TaiKhoanServiceImpl() {
        taiKhoanDAO = new TaiKhoanDAOImpl();
    }
    @Override
    public TaiKhoan login(String tenDangNhap, String matKhau) {
        return taiKhoanDAO.login(tenDangNhap, matKhau);
    }
    
}