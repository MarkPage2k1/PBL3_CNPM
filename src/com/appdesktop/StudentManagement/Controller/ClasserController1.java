package com.appdesktop.StudentManagement.Controller;
import com.appdesktop.StudentManagement.Model.Classer;
import com.appdesktop.StudentManagement.Service.ClasserService;
import com.appdesktop.StudentManagement.Service.ClasserServiceImpl;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClasserController1 {

    private ClasserService classService = null;

    private String idClass = null;
    private JTextField jtfNameClass, jtfIdClass, jtfNameCourse, jtfIdCourse;
    private JCheckBox jcheckStatus;
    private JDateChooser jDateStartOrReg;
    private JTextArea jTextNote;
    private String idCourseOld;
    
    

    final byte Detail = 0;
    final byte Add = 1;
    final byte Edit = 2;
    
    public ClasserController1(String idClass, JTextField jtfIdClass, JTextField jtfNameClass, JTextField jtfIdCourse,
            JTextField jtfNameCourse, JCheckBox jcheckStatus, 
            JDateChooser jDateStartOrReg, JTextArea jTextNote) {
        classService = new ClasserServiceImpl();
        this.idClass = idClass;
        this.jtfIdClass = jtfIdClass;
        this.jtfNameClass = jtfNameClass;
        this.jtfIdCourse = jtfIdCourse;
        this.jtfNameCourse = jtfNameCourse;
        this.jcheckStatus = jcheckStatus;
        this.jDateStartOrReg = jDateStartOrReg;
        this.jTextNote = jTextNote;
        
    }

    public void loadInforClass(){
        try {
            Classer classer = classService.getClass(idClass);            
            if (classer != null) {           
                jtfNameClass.setText(classer.getClassName());
                jtfIdCourse.setText(classer.getCourse_idcourse());
                //jtfNameCourse.setText(classer.getCourse_coursename());
                jcheckStatus.setSelected(classer.isStatus());
                jDateStartOrReg.setDate(classer.getRegistrationdate());
                jTextNote.setText(classer.getRemark());
                //courseController.setCbbOfCourse();

            }
        } catch (Exception e) {
        }
    }

    }
    


