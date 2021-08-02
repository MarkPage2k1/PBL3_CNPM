package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Person;

public interface AdminDAO {
    public Person getAdmin(String idAdmin);
    public boolean updateProfile(Person ps);
}
