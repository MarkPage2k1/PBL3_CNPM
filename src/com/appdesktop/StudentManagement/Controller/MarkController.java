package com.appdesktop.StudentManagement.Controller;
import com.appdesktop.StudentManagement.Model.Mark;
import com.appdesktop.StudentManagement.Service.MarkService;
import com.appdesktop.StudentManagement.Service.MarkServiceImpl;
import javax.swing.JTextField;

public class MarkController {
    
    private JTextField jtfMark1, jtfMark2, jtfMark3;
    private MarkService markService = null;
    
    
    String idCourse = null;
    String idStudent = null;
    
    final byte Add = 1;
    final byte Edit = 2;
    
    public MarkController(String idCourse, String idStudent, JTextField mark1, JTextField mark2, JTextField mark3 ){
        this.idCourse = idCourse;
        this.idStudent = idStudent;
        this.jtfMark1 = mark1;
        this.jtfMark2 = mark2;
        this.jtfMark3 = mark3;
        markService = new MarkServiceImpl();
    }
    
    public void LoadMarkOfStudent(){
        try{
          Mark mark = markService.getMarkOfStudent(idCourse, idStudent);
            jtfMark1.setText(Double.toString(mark.getMark1()));
            jtfMark2.setText(Double.toString(mark.getMark2()));
            jtfMark3.setText(Double.toString(mark.getMark3()));  
        } catch (Exception e) {
            //e.printStackTrace();
        }
        
    }
    
    public boolean updateMarkOfStudnet(byte StatusForForm, String idStudent, String idCourse){
        try {
            Mark mark = new Mark();
            mark.setMark1(Double.parseDouble(jtfMark1.getText()));
            mark.setMark2(Double.parseDouble(jtfMark2.getText()));
            mark.setMark3(Double.parseDouble(jtfMark3.getText()));
            mark.setIdStudent(idStudent);
            mark.setIdCourse(idCourse);
            if (StatusForForm == Edit){
                return markService.updateMarkOfStudent(mark);
            }  
            if (StatusForForm == Add){
                return markService.inserMarkOfStudent(mark);
            }
             
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
        return false;
    }
}
