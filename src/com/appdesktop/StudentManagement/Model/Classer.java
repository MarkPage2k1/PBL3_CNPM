package com.appdesktop.StudentManagement.Model;

import java.util.Date;

public class Classer {
    private String idClass;
    private String className;
    private boolean status;
    private String remark;
    private Date startDate;
    private Date endDate;
    private String course_idcourse;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCourse_idcourse() {
        return course_idcourse;
    }

    public void setCourse_idcourse(String course_idcourse) {
        this.course_idcourse = course_idcourse;
    } 
}
