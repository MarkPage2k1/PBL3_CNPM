package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Person;
import java.util.List;

public interface TeacherDAO {
    public List<Person> getAllTeacher();
    public Person getIDTeacher(String idTeacher);
    public boolean updateProfile(Person ps);
    public boolean updateTeacher(Person teacher);
    public boolean inserTeacher(Person teacher);
    public boolean deleteTeacher(String idTeacher);
}
