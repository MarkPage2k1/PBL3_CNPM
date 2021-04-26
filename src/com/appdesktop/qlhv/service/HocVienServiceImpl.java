package com.appdesktop.qlhv.service;

import com.appdesktop.qlhv.dao.HocVienDAO;
import com.appdesktop.qlhv.dao.HocVienDAOImpl;
import com.appdesktop.qlhv.model.HocVien;
import java.util.List;

public class HocVienServiceImpl implements HocVienService{
    private HocVienDAO hocVienDAO = null;

    public HocVienServiceImpl(){
        hocVienDAO = new HocVienDAOImpl();
    }
    @Override
    public List<HocVien> getList() {
        return hocVienDAO.getList();
        
    }

    @Override
    public int createOrUpdate(HocVien hocVien) {
        return hocVienDAO.createOrUpdate(hocVien);
    }
    
    
}
