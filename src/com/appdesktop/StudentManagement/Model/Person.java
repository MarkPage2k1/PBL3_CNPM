package com.appdesktop.StudentManagement.Model;

import java.util.Date;

public class Person {
    private String Id;
    private String Name;
    private Date Brithday;
    private boolean Gender;
    private String Address;
    private boolean Status;
    private String Email;
    private String Phone;   
    private byte[] Avatar;
    private String account_username;

    public Person() {
    }

    public Person(String Id, String Name, Date Brithday, boolean Gender, String Address
            , boolean Status, String Email, String Phone, byte[] Avatar, String account_username) {
        this.Id = Id;
        this.Name = Name;
        this.Brithday = Brithday;
        this.Gender = Gender;
        this.Address = Address;
        this.Status = Status;
        this.Email = Email;
        this.Phone = Phone;
        this.Avatar = Avatar;
        this.account_username = account_username;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Date getBrithday() {
        return Brithday;
    }

    public void setBrithday(Date Brithday) {
        this.Brithday = Brithday;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public byte[] getAvatar() {
        return Avatar;
    }

    public void setAvatar(byte[] Avatar) {
        this.Avatar = Avatar;
    }

    public String getAccount_username() {
        return account_username;
    }

    public void setAccount_username(String account_username) {
        this.account_username = account_username;
    }
    
    
      
}

