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
        tblModelRegister.setColumnIdentifiers(new String[] {"Mã lớp học", "Tên lớp học", "Mã khóa học", "Tên khóa học", "Giảng Viên", "Ghi chú", "Tình trạng", "Ngày tạo"});
        jTableClassRegister.setModel(tblModelRegister);
    }
    public void initTableRegisted() {
        tblModelRegisted = new DefaultTableModel();
        tblModelRegisted.setColumnIdentifiers(new String[] {"Mã lớp học", "Tên lớp học", "Mã khóa học", "Tên khóa học", "Giảng Viên", "Ghi chú", "Tình trạng", "Ngày đăng ký"});
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
                    i.isStatus() ? "Hoạt động" : "Khóa",
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
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
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
                    i.isStatus() ? "Hoạt động" : "Khóa",
                    i.getRegisterDate()
                });
            tblModelRegisted.fireTableDataChanged();
            }
            rowSorter = new TableRowSorter<>(jTableClassRegisted.getModel());
            jTableClassRegisted.setRowSorter(rowSorter);
                
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    
    public void setCbb(){
        try{             
            List<Course> list = courseService.getAllCourses();
            for (Course i :  list){    
                comboBox.addItem(new CBBItem(i.getIdCourse(), i.getCourseName()));
            }
            if (comboBox.getSelectedIndex() < 0) {
                MessageDialogHelper.showMessageDialog(parentForm, "Hiện tại hệ thống chưa có khóa học nào!\nVui lòng cập nhật thêm!", "Thông Báo!");
            }
        } catch (java.lang.Exception e){
            //e.printStackTrace();
        }
    }
    
    public void registerClassOfStudent(String idClass, String idCourse){       
        try {    
            if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn đăng ký lớp học này?", "Hỏi") 
                == JOptionPane.NO_OPTION) {
                return;
            } 
            if (!cStudentService.registerClassOfStudent(idClass, idCourse, IDUSER)) {
                MessageDialogHelper.showErrorDialog(parentForm, "Đăng ký không thành công!", "Cảnh báo");                      
                return;
            }
                loadDataTableRegisted();
                MessageDialogHelper.showMessageDialog(parentForm, "Đăng ký thành công!", "Thông báo");
                 
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    
    public void deleteClassOfStudent(int rows[]){       
        String idClass, idCourse = null;
        try {    
            if (rows.length > 0) {
                if (MessageDialogHelper.showConfirmDialog(parentForm, "Bạn có muốn hủy đăng ký lớp học này?", "Hỏi") 
                        == JOptionPane.NO_OPTION) {
                        return;
                } 
                for (int s : rows) {
                    idClass = (String) jTableClassRegisted.getValueAt(s, 0);
                    idCourse = (String) jTableClassRegisted.getValueAt(s, 2);                   
                    if (!cStudentService.deleteClassOfStudent(idClass, idCourse, IDUSER)) {
                        MessageDialogHelper.showErrorDialog(parentForm, "Xóa không thành công!", "Cảnh báo");                      
                        return;
                    }
                }
                loadDataTableRegisted();
                MessageDialogHelper.showMessageDialog(parentForm, "Xóa thành công!", "Thông báo");
            } else {
                MessageDialogHelper.showErrorDialog(parentForm, "Bạn chưa chọn lớp cần xóa!", "Cảnh báo");  
            } 
                 
        } catch (Exception e) {
            //e.printStackTrace();
            MessageDialogHelper.showErrorDialog(parentForm, e.getMessage(), "Lỗi");
        }
    }
    
}
