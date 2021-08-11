package com.appdesktop.StudentManagement.Model;

import java.util.Date;

public class Class_Student 
{   
    private String id_class_student; // id_class_teacher
    private String idClass;
    private String className;
    private String idCourse;
    private String courseName;
    private String tchName;
    private String remark;
    private boolean status;
    private Date registerDate;

    public String getId_class_student() {
        return id_class_student;
    }

    public void setId_class_student(String id_class_student) {
        this.id_class_student = id_class_student;
    }
    
    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTchName() {
        return tchName;
    }

    public void setTchName(String tchName) {
        this.tchName = tchName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
    
    
}
