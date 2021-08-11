package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.Class_TeacherDAO;
import com.appdesktop.StudentManagement.Dao.Class_TeacherDAOImpl;
import com.appdesktop.StudentManagement.Model.Class_Teacher;
import com.appdesktop.StudentManagement.Model.studentOfClass;
import java.util.List;

public class Class_TeacherServiceImpl implements Class_TeacherService{
    private Class_TeacherDAO cTeacherDao = null;

    public Class_TeacherServiceImpl(){
        cTeacherDao = new Class_TeacherDAOImpl();
    }
    @Override
    public List<Class_Teacher> getAllClassOfTeacher(String idTeacher) {
        return cTeacherDao.getAllClassOfTeacher(idTeacher);
    }

    @Override
    public boolean deleteClassOfTeacher(String idClass, String idCourse, String idTeacher) {
        return cTeacherDao.deleteClassOfTeacher(idClass, idCourse, idTeacher);
    }

    @Override
    public boolean registerClassOfTeacher(String idClass, String idCourse, String idTeacher) {
        return cTeacherDao.registerClassOfTeacher(idClass, idCourse, idTeacher);
    }

    @Override
    public String getNameTeacherOfClass(String idClass) {
        return cTeacherDao.getNameTeacherOfClass(idClass);
    }

    @Override
    public List<studentOfClass> getAllStudentOfClass(String idClass) {
        return cTeacherDao.getAllStudentOfClass(idClass);
    }
    
}
