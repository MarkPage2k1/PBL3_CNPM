package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.Class_StudentDAO;
import com.appdesktop.StudentManagement.Dao.Class_StudentDAOImpl;
import com.appdesktop.StudentManagement.Model.Class_Student;
import com.appdesktop.StudentManagement.Model.ListStudent;
import java.util.List;

public class Class_StudentServiceImpl implements Class_StudentService
{
    private Class_StudentDAO cStudentDao = null;
    
    public Class_StudentServiceImpl(){
        cStudentDao = new Class_StudentDAOImpl();
    }
    @Override
    public List<Class_Student> getAllClassOfTeachers(String idCourse) {
        return cStudentDao.getAllClassOfTeachers(idCourse);
    }

    @Override
    public List<Class_Student> getAllClassOfStudent(String idStudent) {
        return cStudentDao.getAllClassOfStudent(idStudent);
    }

    @Override
    public boolean registerClassOfStudent(String idClass, String idCourse, String idStudent) {
        return cStudentDao.registerClassOfStudent(idClass, idCourse, idStudent);
    }

    @Override
    public boolean deleteClassOfStudent(String idClass, String idCourse, String idStudent) {
        return cStudentDao.deleteClassOfTeacher(idClass, idCourse, idStudent);
    }

    @Override
        public List<ListStudent> getAllStudent(String id_class_teacher) {
        return cStudentDao.getAllStudent(id_class_teacher);
    }
    
}
