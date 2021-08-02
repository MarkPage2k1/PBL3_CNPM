package com.appdesktop.StudentManagement.Controller;
import com.appdesktop.StudentManagement.Model.CBBItem;
import com.appdesktop.StudentManagement.Model.Classer;
import com.appdesktop.StudentManagement.Service.ClasserService;
import com.appdesktop.StudentManagement.Service.ClasserServiceImpl;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClassController {

    private ClasserService classService = null;

    private String idClass = null;
    JTextField jtfIdClass;
    private JTextField jtfClassName;
    private JCheckBox jcheckStatus;
    private JComboBox<Object> jcomboBox;
    private JDateChooser jDateStartOrReg;
    private JDateChooser jDateEnd;
    private JTextArea jTextNote;
    private String idCourseOld;
    
    

    final byte Detail = 0;
    final byte Add = 1;
    final byte Edit = 2;
    
    public ClassController(String idClass, JTextField jtfIdClass, JTextField jtfClassName, JCheckBox jcheckStatus, JComboBox<Object> jcomboBox,
            JDateChooser jDateStartOrReg, JDateChooser jDateEnd, JTextArea jTextNote) {
        classService = new ClasserServiceImpl();
        this.idClass = idClass;
        this.jtfIdClass = jtfIdClass;
        this.jtfClassName = jtfClassName;
        this.jcheckStatus = jcheckStatus;
        this.jcomboBox = jcomboBox;
        this.jDateStartOrReg = jDateStartOrReg;
        this.setjDateEnd(jDateEnd);
        this.jTextNote = jTextNote;
        
    }
    

    
    public JDateChooser getjDateEnd() {
        return jDateEnd;
    }



    public void setjDateEnd(JDateChooser jDateEnd) {
        this.jDateEnd = jDateEnd;
    }



    public void loadInforClass(){
        try {
            Classer classer = classService.getClass(idClass);
            CourseController courseController = new CourseController(jcomboBox );
            
   
            if (classer != null) {           
                jtfClassName.setText(classer.getClassName());
                jcheckStatus.setSelected(classer.isStatus());
                jDateStartOrReg.setDate(classer.getRegistrationdate());
                jTextNote.setText(classer.getRemark());
                courseController.setCbbOfCourse();
                String idCourse = null; 
                String ID = classer.getCourse_idcourse();
                
                for (int index = 0; index < jcomboBox.getItemCount(); index++){
                    idCourse = ((CBBItem)jcomboBox.getItemAt(index)).Value;
                    if (ID.equals(idCourse)){
                        jcomboBox.setSelectedIndex(index);
                        idCourseOld = ((CBBItem)jcomboBox.getSelectedItem()).Value;
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }
    
    public boolean updateInforClass(String idCourse, byte StatusForForm){
        try {
            Classer classer = new Classer();
            classer.setIdClass(jtfIdClass.getText());
            classer.setClassName(jtfClassName.getText());
            classer.setStatus(jcheckStatus.isSelected());
            classer.setRegistrationdate(convertDateToDateSql(jDateStartOrReg.getDate()));
            classer.setRemark(jTextNote.getText());
            classer.setCourse_idcourse(idCourse);
              
          
            if (StatusForForm == Edit){
                System.out.println(idCourseOld + " - " + idCourse);
                return classService.updateInforClass(classer, idCourseOld); 
            }  
            
            if (StatusForForm == Add)
                return classService.insertInforClass(classer);
              
        } catch (Exception e) {
            //e.printStackTrace();
            return false;
        }
        return false;
    }
    private java.sql.Date convertDateToDateSql(Date d) {
        return new java.sql.Date(d.getTime());
    }
    
}
