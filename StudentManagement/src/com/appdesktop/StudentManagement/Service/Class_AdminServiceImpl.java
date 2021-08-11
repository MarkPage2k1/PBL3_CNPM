/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.Class_AdminDAO;
import com.appdesktop.StudentManagement.Dao.Class_AdminDAOImpl;
import com.appdesktop.StudentManagement.Model.Class_Admin;
import java.util.List;

/**
 *
 * @author Duy Ngoc <duylengoc1111@gmail.com>
 */
public class Class_AdminServiceImpl implements Class_AdminService
{
    private Class_AdminDAO class_adDao = null;
    public Class_AdminServiceImpl()
    {
        class_adDao = new Class_AdminDAOImpl();
    }
    @Override
    public List<Class_Admin> getAll_ClassAdmin() 
    {
        return class_adDao.getAll_ClassAdmin();
    }

    @Override
    public boolean InsertClass(String idClass, String idCourse, String idteacher) {
        return class_adDao.InsertClass(idClass,idCourse,idteacher);
    }

    @Override
        public boolean UpdateClass(String idClass, String idCourse, String idteacher, String id_class_teacher) {
            return class_adDao.UpdateClass(idClass, idCourse, idteacher, id_class_teacher);
        }

    @Override
    public boolean DeleteClass(String idclass) {
        return class_adDao.DeleteClass(idclass);
    }

    @Override
    public List<Class_Admin> getAll_ClassAdminbyID(String idCourse) {
        return class_adDao.getAll_ClassAdminbyID(idCourse);
    }

    @Override
    public Class_Admin getClass_AdminByID(String idclass_admin) {
        return class_adDao.getClass_AdminByID(idclass_admin);
    }
    
}
