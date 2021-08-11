package com.appdesktop.StudentManagement.Dao;

import com.appdesktop.StudentManagement.Model.Classer;
import java.util.List;

public interface ClasserDAO {
    public List<Classer> getAllClassOfCourse(String idCouse);
    public Classer getClass(String idClass);
    public boolean updateInforClass(Classer classer, String idCourseOld);
    public boolean insertInforClass(Classer classer);
    public boolean deleteClass(String idClass, String idCourse);
}
