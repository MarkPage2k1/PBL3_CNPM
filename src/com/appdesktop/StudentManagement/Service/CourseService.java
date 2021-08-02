package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Model.Course;
import java.util.List;

public interface CourseService {
    public List<Course> getAllCourses();
    public Course getCourse(String idCourse);
    public boolean updateInforCourse(Course course);
    public boolean insertInforCourse(Course course);
    public boolean deleteCourse(String idCourse);
}
