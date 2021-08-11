package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Bean.ClassBean;
import com.appdesktop.StudentManagement.Bean.CourseBean;
import java.util.List;


public interface AnalytisService {
    public List<ClassBean> getListByClass();
    public List<CourseBean> getListByCourse();
}
