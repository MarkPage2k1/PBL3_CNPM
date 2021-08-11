package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Model.Class_Student;
import com.appdesktop.StudentManagement.Model.ListStudent;
import java.util.List;

public interface Class_StudentService {
    public List<Class_Student> getAllClassOfTeachers(String idCourse);
    public List<Class_Student> getAllClassOfStudent(String idStudent);
    public boolean registerClassOfStudent(String idClass, String idCourse, String idStudent);
    public List<ListStudent> getAllStudent(String id_class_teacher);
    public boolean deleteClassOfStudent(String idClass, String idCourse, String idStudent);
}
