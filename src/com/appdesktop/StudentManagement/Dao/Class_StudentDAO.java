package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Class_Student;
import java.util.List;


public interface Class_StudentDAO {
    public List<Class_Student> getAllClassOfTeachers(String idCourse);
    public List<Class_Student> getAllClassOfStudent(String idStudent);
    public boolean registerClassOfStudent(String idClass, String idCourse, String idStudent);
    public boolean deleteClassOfTeacher(String idClass, String idCourse, String idTeacher);
}
