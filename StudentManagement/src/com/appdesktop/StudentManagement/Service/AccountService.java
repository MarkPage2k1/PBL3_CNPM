package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Model.Account;

public interface AccountService {
    public Account login(String username, String password);
    public boolean inserAcount (Account account);
    public boolean deleteAcount(String username);
}
