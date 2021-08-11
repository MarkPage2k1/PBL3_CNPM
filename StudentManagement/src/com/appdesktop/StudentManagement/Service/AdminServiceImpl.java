package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.AdminDAO;
import com.appdesktop.StudentManagement.Dao.AdminDAOImpl;
import com.appdesktop.StudentManagement.Model.Person;

public class AdminServiceImpl implements AdminService{

    private AdminDAO adminDao = null;

    public AdminServiceImpl(){
        adminDao = new AdminDAOImpl();
    }
    @Override
    public Person getAdmin(String idAdmin) {
        return adminDao.getAdmin(idAdmin);
    }

    @Override
    public boolean updateProfile(Person ps) {
        return adminDao.updateProfile(ps);
    }
    
}
