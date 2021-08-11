
package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Model.Mark;

public interface MarkService {
    public boolean inserMarkOfStudent(Mark mark);
    public boolean updateMarkOfStudent(Mark mark);
    public Mark getMarkOfStudent(String idCourse, String idStudent);
}
