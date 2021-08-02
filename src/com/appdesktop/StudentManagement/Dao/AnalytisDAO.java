package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Bean.ClassBean;
import com.appdesktop.StudentManagement.Bean.CourseBean;
import java.util.List;

public interface AnalytisDAO {
    public List<ClassBean> getListByClass();
    public List<CourseBean> getListByCourse();
}
