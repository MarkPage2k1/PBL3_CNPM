package com.appdesktop.StudentManagement.Controller;
import com.appdesktop.StudentManagement.DBHelpers.MessageDialogHelper;
import com.appdesktop.StudentManagement.DBHelpers.sharedData;
import com.appdesktop.StudentManagement.Model.CBBItem;
import com.appdesktop.StudentManagement.Model.Class_Student;
import com.appdesktop.StudentManagement.Model.Course;
import com.appdesktop.StudentManagement.Service.Class_StudentService;
import com.appdesktop.StudentManagement.Service.Class_StudentServiceImpl;
import com.appdesktop.StudentManagement.Service.CourseService;
import com.appdesktop.StudentManagement.Service.CourseServiceImpl;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Class_StudentController {
    private Class_StudentService cStudentService = null;
    private CourseService courseService = null;
    private JComboBox<Object> comboBox;
    private JFrame parentForm;
    JTextField jtfSearch;
    private DefaultTableModel tblModelRegister, tblModelRegisted;
    private JTable jTableClassRegister, jTableClassRegisted;
    private TableRowSorter<TableModel> rowSorter = null;
    final private String IDUSER = sharedData.userLogin.getUsername();
    
    public Class_StudentController (JComboBox<Object> comboBox, JFrame parentForm, JTable jTableClassRegister, JTable jTableClassRegisted, JTextField jtfSearch) {
        this.parentForm = parentForm;
        this.jTableClassRegister = jTableClassRegister;
        this.jTableClassRegisted = jTableClassRegisted;
        this.comboBox = comboBox;
        this.jtfSearch = jtfSearch;
        cStudentService = new Class_StudentServiceImpl();
        courseService = new CourseServiceImpl();   
    }
    
    public void initTableRegister() {
        tblModelRegister = new DefaultTableModel();
        tblModelRegister.setColumnIdentifiers(new String[] {"M?? l???p h???c", "T??n l???p h???c", "M?? kh??a h???c", "T??n kh??a h???c", "Gi???ng Vi??n", "Ghi ch??", "T??nh tr???ng", "Ng??y t???o"});
        jTableClassRegister.setModel(tblModelRegister);
    }
    public void initTableRegisted() {
        tblModelRegisted = new DefaultTableModel();
        tblModelRegisted.setColumnIdentifiers(new String[] {"M?? l???p h???c", "T??n l???p h???c", "M?? kh??a h???c", "T??n kh??a h???c", "Gi???ng Vi??n", "Ghi ch??", "T??nh tr???ng", "Ng??y ????ng k??"});
        jTableClassRegisted.setModel(tblModelRegisted);
    }
    
    public void loadDataTableRegister() {
        try {
            String idCourse = ((CBBItem)comboBox.getSelectedItem()).Value;
            List<Class_Student> list = cStudentService.getAllClassOfTeachers(idCourse);
            tblModelRegister.setRowCount(0);
            for (Class_Student i : list) {
                tblModelRegister.addRow(new Object[] {
                    i.getIdClass(),
                    i.getClassName(),
                    i.getIdCourse(),
                    i.getCourseName(),
                    i.getTchName(),
                    i.getRemark(),
                    i.isStatus() ? "Ho???t ?????ng" : "Kh??a",
                    i.getRegisterDate()
                });
            tblModelRegister.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableClassRegister.getModel());
            jTableClassRegister.setRowSorter(rowSorter);
            
            jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    String text = jtfSearch.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    } 
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    String text = jtfSearch.getText();
                    if (text.trim().length() == 0) {
                        rowSorter.setRowFilter(null);
                    } else {
                        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    } 
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });
                
        } catch (Exception e) {
            // e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "L???i");
        }
    }
    
    public void loadDataTableRegisted() {
        try {
            List<Class_Student> list = cStudentService.getAllClassOfStudent(IDUSER);
            tblModelRegisted.setRowCount(0);
            for (Class_Student i : list) {
                tblModelRegisted.addRow(new Object[] {
                    i.getIdClass(),
                    i.getClassName(),
                    i.getIdCourse(),
                    i.getCourseName(),
                    i.getTchName(),
                    i.getRemark(),
                    i.isStatus() ? "Ho???t ?????ng" : "Kh??a",
                    i.getRegisterDate()
                });
            tblModelRegisted.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableClassRegisted.getModel());
            jTableClassRegisted.setRowSorter(rowSorter);
                
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "L???i");
        }
    }
    
    public void setCbb(){
        try{             
            List<Course> list = courseService.getAllCourses();
            for (Course i :  list){    
                comboBox.addItem(new CBBItem(i.getIdCourse(), i.getCourseName()));
            }
            if (comboBox.getSelectedIndex() < 0) {
                MessageDialogHelper.showMessageDialog(parentForm, "Hi???n t???i h??? th???ng ch??a c?? kh??a h???c n??o!\nVui l??ng c???p nh???t th??m!", "Th??ng B??o!");
            }
        } catch (java.lang.Exception e){
            //e.printStackTrace();
        }
    }
    
    public void registerClassOfStudent(String idClass, String idCourse){       
        try {    
            if (MessageDialogHelper.showConfirmDialog(parentForm, "B???n c?? mu???n ????ng k?? l???p h???c n??y?", "H???i") 
                == JOptionPane.NO_OPTION) {
                return;
            } 
            if (!cStudentService.registerClassOfStudent(idClass, idCourse, IDUSER)) {
                MessageDialogHelper.showErrorDialog(parentForm, "????ng k?? kh??ng th??nh c??ng!", "C???nh b??o");                      
                return;
            }
                loadDataTableRegisted();
                MessageDialogHelper.showMessageDialog(parentForm, "????ng k?? th??nh c??ng!", "Th??ng b??o");
                 
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "L???i");
        }
    }
    
    public void deleteClassOfStudent(int rows[]){       
        String idClass, idCourse = null;
        try {    
            if (rows.length > 0) {
                if (MessageDialogHelper.showConfirmDialog(parentForm, "B???n c?? mu???n h???y ????ng k?? l???p h???c n??y?", "H???i") 
                        == JOptionPane.NO_OPTION) {
                        return;
                } 
                for (int s : rows) {
                    idClass = (String) jTableClassRegisted.getValueAt(s, 0);
                    idCourse = (String) jTableClassRegisted.getValueAt(s, 2);                   
                    if (!cStudentService.deleteClassOfStudent(idClass, idCourse, IDUSER)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "X??a kh??ng th??nh c??ng!", "C???nh b??o");                      
                        return;
                    }
                }
                loadDataTableRegisted();
                MessageDialogHelper.showMessageDialog(parentForm, "X??a th??nh c??ng!", "Th??ng b??o");
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "B???n ch??a ch???n l???p c???n x??a!", "C???nh b??o");  
            } 
                 
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "L???i");
        }
    }
    
}
