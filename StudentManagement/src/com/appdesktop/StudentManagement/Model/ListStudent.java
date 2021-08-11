/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.StudentManagement.Model;

/**
 *
 * @author Duy Ngoc <duylengoc1111@gmail.com>
 */
public class ListStudent 
{
    private String Idclass;
    private String classname;
    private String id_student;
    private String namestudent;
    private String phonenumb;
    private String coursename;

    public String getIdclass() {
        return Idclass;
    }

    public void setIdclass(String Idclass) {
        this.Idclass = Idclass;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getNamestudent() {
        return namestudent;
    }

    public void setNamestudent(String namestudent) {
        this.namestudent = namestudent;
    }

    public String getPhonenumb() {
        return phonenumb;
    }

    public void setPhonenumb(String phonenumb) {
        this.phonenumb = phonenumb;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
    
   
}
