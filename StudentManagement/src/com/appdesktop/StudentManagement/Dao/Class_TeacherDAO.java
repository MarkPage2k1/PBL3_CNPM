package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Class_Teacher;
import com.appdesktop.StudentManagement.Model.studentOfClass;
import java.util.List;


public interface Class_TeacherDAO {
    public List<Class_Teacher> getAllClassOfTeacher(String idTeacher);
    public List<studentOfClass> getAllStudentOfClass(String idClass);
    public boolean deleteClassOfTeacher(String idClass, String idCourse, String idStudent);
    public boolean registerClassOfTeacher(String idClass, String idCourse, String idStudent);
    public String getNameTeacherOfClass(String idClass);
}
