package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Bean.ClassBean;
import com.appdesktop.StudentManagement.Bean.CourseBean;
import com.appdesktop.StudentManagement.Dao.AnalytisDAO;
import com.appdesktop.StudentManagement.Dao.AnalytisDAOImpl;
import java.util.List;

public class AnalytisServiceImpl implements AnalytisService{

    private AnalytisDAO analytisDAO = null;
    
    public AnalytisServiceImpl() {
        this.analytisDAO = new AnalytisDAOImpl();
    }
    @Override
    public List<ClassBean> getListByClass() {
        return analytisDAO.getListByClass();
    }

    @Override
    public List<CourseBean> getListByCourse() {
        return analytisDAO.getListByCourse();
    }
    
}
