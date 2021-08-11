package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.AccountDAO;
import com.appdesktop.StudentManagement.Dao.AccountDAOImpl;
import com.appdesktop.StudentManagement.Model.Account;

public class AccountServiceImpl implements AccountService{
    private AccountDAO accountDao = null;

    public AccountServiceImpl() {
        accountDao = new AccountDAOImpl();
    }
    @Override
    public Account login(String username, String password) {
        return accountDao.login(username, password);
    }

    @Override
    public boolean inserAcount(Account account) {
        return accountDao.inserAcount(account);
    }

    @Override
    public boolean deleteAcount(String username) {
        return accountDao.deleteAcount(username);
    }
}
