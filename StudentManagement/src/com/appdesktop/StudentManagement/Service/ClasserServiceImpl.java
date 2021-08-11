package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.ClasserDAOImpl;
import com.appdesktop.StudentManagement.Model.Classer;
import com.appdesktop.StudentManagement.Dao.ClasserDAO;
import java.util.List;

public class ClasserServiceImpl implements ClasserService{
    private ClasserDAO classerDao = null;

    public ClasserServiceImpl(){
        classerDao = new ClasserDAOImpl();
    }
    @Override
    public List<Classer> getAllClassOfCourse(String idCouse) {
        return classerDao.getAllClassOfCourse(idCouse);
    }

    @Override
    public Classer getClass(String idClass) {
        return classerDao.getClass(idClass);
    }

    @Override
    public boolean updateInforClass(Classer classer, String idCourseOld) {
        return classerDao.updateInforClass(classer, idCourseOld);
    }

    @Override
    public boolean insertInforClass(Classer classer) {
        return classerDao.insertInforClass(classer);
    }

    @Override
    public boolean deleteClass(String idClass, String idCourse) {
        return classerDao.deleteClass(idClass, idCourse);
    }

    
}
