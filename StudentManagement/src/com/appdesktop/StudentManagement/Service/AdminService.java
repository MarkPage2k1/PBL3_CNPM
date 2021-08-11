package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Model.Person;

public interface AdminService {
    public Person getAdmin(String idAdmin);
    public boolean updateProfile(Person ps);
}
