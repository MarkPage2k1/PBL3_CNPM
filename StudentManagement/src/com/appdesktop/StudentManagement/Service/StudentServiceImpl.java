package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.StudentDAO;
import com.appdesktop.StudentManagement.Dao.StudentDAOImpl;
import com.appdesktop.StudentManagement.Model.Person;
import java.util.List;

public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDao = null;

    public StudentServiceImpl(){
        studentDao = new StudentDAOImpl();
    }
    @Override
    public List<Person> getAllStudent() {
        return studentDao.getAllStudent();
    }

    @Override
    public Person getStudent(String idStudent) {
        return studentDao.getStudent(idStudent);
    }

    @Override
    public boolean updateStudent(Person student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public boolean inserStudent(Person student) {
        return studentDao.inserStudent(student);
    }

    @Override
    public boolean deleteStudent(String idStudent) {
        return studentDao.deleteStudent(idStudent);
    }

    @Override
    public boolean updateProfile(Person ps) {
        return studentDao.updateProfile(ps);
    }

    @Override
    public List<Person> getListExport() {
        return studentDao.getListExport();
    }
   
}
