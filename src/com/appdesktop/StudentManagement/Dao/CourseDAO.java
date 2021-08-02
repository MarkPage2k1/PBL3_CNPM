package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Course;
import java.util.List;

public interface CourseDAO {
    public List<Course> getAllCourses();
    public Course getCourse(String idCourse);
    public boolean updateInforCourse(Course course);
    public boolean insertInforCourse(Course course);
    public boolean deleteCourse(String idCourse);
}
