
package com.appdesktop.StudentManagement.Service;

import com.appdesktop.StudentManagement.Dao.MarkDao;
import com.appdesktop.StudentManagement.Dao.MarkDaoImpl;
import com.appdesktop.StudentManagement.Model.Mark;

public class MarkServiceImpl implements MarkService{

    private MarkDao markDAO = null;
    public MarkServiceImpl(){
        markDAO = new MarkDaoImpl();
    }
    @Override
    public boolean inserMarkOfStudent(Mark mark) {
        return markDAO.inserMarkOfStudent(mark);
    }

    @Override
    public boolean updateMarkOfStudent(Mark mark) {
        return markDAO.updateMarkOfStudent(mark);
    }

    @Override
    public Mark getMarkOfStudent(String idCourse, String idStudent) {
        return markDAO.getMarkOfStudent(idCourse, idStudent);
    }
    
}
