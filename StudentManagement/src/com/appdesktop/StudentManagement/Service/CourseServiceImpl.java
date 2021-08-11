package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.CourseDAO;
import com.appdesktop.StudentManagement.Dao.CourseDAOIpml;
import com.appdesktop.StudentManagement.Model.Course;
import java.util.List;

public class CourseServiceImpl implements CourseService{
    private CourseDAO courseDao = null;

    public CourseServiceImpl(){
        courseDao = new CourseDAOIpml();
    }
    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Course getCourse(String idCourse) {
        return courseDao.getCourse(idCourse);
    }

    @Override
    public boolean updateInforCourse(Course course) {
        return courseDao.updateInforCourse(course);
    }

    @Override
    public boolean insertInforCourse(Course course) {
        return courseDao.insertInforCourse(course);
    }

    @Override
    public boolean deleteCourse(String idCourse) {
        return courseDao.deleteCourse(idCourse);
    }

    @Override
    public String getIdCourse(String nameCourse) {
        return courseDao.getIdCourse(nameCourse);
    }
    
}
