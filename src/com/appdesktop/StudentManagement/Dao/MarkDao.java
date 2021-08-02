package com.appdesktop.StudentManagement.Dao;
import com.appdesktop.StudentManagement.Model.Mark;

public interface MarkDao {
    public boolean inserMarkOfStudent(Mark mark);
    public boolean updateMarkOfStudent(Mark mark);
    public Mark getMarkOfStudent(String idCourse, String idStudent);
}