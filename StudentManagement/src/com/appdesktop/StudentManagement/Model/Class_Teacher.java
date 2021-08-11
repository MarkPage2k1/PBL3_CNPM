package com.appdesktop.StudentManagement.Model;

import java.util.Date;

public class Class_Teacher {
    private String id_class_teacher;
    private String idClass;
    private String className;
    private String idCourse;
    private String courseName;
    private boolean status;
    private Date registerDate;

    
    public String getId_class_teacher() {
        return id_class_teacher;
    }

    public void setId_class_teacher(String id_class_teacher) {
        this.id_class_teacher = id_class_teacher;
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
