/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appdesktop.StudentManagement.Model;

import java.util.Date;

/**
 *
 * @author Duy Ngoc <duylengoc1111@gmail.com>
 */
public class Class_Admin 
{
    private String id_class_teacher;
    private String id_class;
    private String classname;
    private String namecourse;
    private String Teachername;
    private boolean status;
    private Date startdate;
    private Date enddate;

    
    public String getId_class_teacher() {
        return id_class_teacher;
    }

    public void setId_class_teacher(String id_class_teacher) {
        this.id_class_teacher = id_class_teacher;
    }
    public String getId_class() {
        return id_class;
    }

    public void setId_class(String id_class) {
        this.id_class = id_class;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

//    public String getId_course() {
//        return id_course;
//    }
//
//    public void setId_course(String id_course) {
//        this.id_course = id_course;
//    }

    public String getNamecourse() {
        return namecourse;
    }

    public void setNamecourse(String namecourse) {
        this.namecourse = namecourse;
    }

    public String getTeachername() {
        return Teachername;
    }

    public void setTeachername(String Teachername) {
        this.Teachername = Teachername;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enđate) {
        this.enddate = enđate;
    }
    
    
}
