package com.appdesktop.qlhv.service;


import com.appdesktop.qlhv.bean.KhoaHocBean;
import com.appdesktop.qlhv.bean.LopHocBean;
import com.appdesktop.qlhv.dao.ThongKeDAO;
import com.appdesktop.qlhv.dao.ThongKeDAOImpl;
import com.appdesktop.qlhv.service.ThongKeService;
import java.util.List;


public class ThongKeServiceImpl implements ThongKeService{

    private ThongKeDAO thongKeDAO = null;
    
    public ThongKeServiceImpl() {
        this.thongKeDAO = new ThongKeDAOImpl();
    }
    @Override
    public List<LopHocBean> getListByLopHoc() {
        return thongKeDAO.getListByLopHoc();
    }

    @Override
    public List<KhoaHocBean> getListByKhoaHoc() {
        return thongKeDAO.getListByKhoaHoc();
    }
    
}
