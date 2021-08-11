package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Person;
import java.util.List;

public interface StudentDAO {
    public List<Person> getAllStudent();
    public Person getStudent(String idStudent);
    public boolean updateStudent(Person student);
    public boolean inserStudent (Person student);
    public boolean deleteStudent(String idStudent);
    public boolean updateProfile(Person ps);
    public List<Person> getListExport();
}
