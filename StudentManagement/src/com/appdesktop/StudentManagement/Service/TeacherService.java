package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Model.Person;
import java.util.List;

public interface TeacherService {
    public List<Person> getAllTeacher();
    public Person getTeacher(String idTeacher);
    public boolean updateProfile(Person ps);
    public boolean updateTeacher(Person teacher);
    public boolean inserTeacher(Person teacher);
    public boolean deleteTeacher(String idTeacher);
    public String getIdTeacher(String Teachername);
}
