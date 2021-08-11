package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.TeacherDAO;
import com.appdesktop.StudentManagement.Dao.TeacherDAOImpl;
import com.appdesktop.StudentManagement.Model.Person;
import java.util.List;

public class TeacherServiceImpl implements TeacherService{
    private TeacherDAO teacherDao = null;

    public TeacherServiceImpl(){
        teacherDao = new TeacherDAOImpl();
    }
    
    @Override
    public Person getTeacher(String idTeacher) {
        return teacherDao.getTeacher(idTeacher);
    }

    @Override
    public boolean updateProfile(Person ps) {
        return teacherDao.updateProfile(ps);
    }

    @Override
    public boolean updateTeacher(Person teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    @Override
    public boolean inserTeacher(Person teacher) {
        return teacherDao.inserTeacher(teacher);
    }

    @Override
    public boolean deleteTeacher(String idTeacher) {
        return teacherDao.deleteTeacher(idTeacher);
    }

    @Override
    public List<Person> getAllTeacher() {
        return teacherDao.getAllTeacher();
        
    }

    @Override
    public String getIdTeacher(String Teachername) {
        return teacherDao.getIdTeacher(Teachername);
    }
    
}
