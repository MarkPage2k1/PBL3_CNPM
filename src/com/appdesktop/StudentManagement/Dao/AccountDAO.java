package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Account;

public interface AccountDAO {
    public Account login(String username, String password);
    public boolean inserAcount (Account account);
    public boolean deleteAcount(String username);
}
